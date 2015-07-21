/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pr.nb.csv.nodes;

import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.nodes.ChildFactory;
import org.openide.nodes.Node;
import org.openide.util.Cancellable;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.util.RequestProcessor;
import org.openide.util.Task;
import org.openide.util.TaskListener;
import org.pr.nb.csv.nodes.data.CSVRow;
import org.pr.nb.csv.nodes.data.CSVSheet;

/**
 *
 * @author Kaiser
 */
@NbBundle.Messages({
    "waitnode.text=Please wait, reading file",
    "# {0} - File being read from",
    "reading.progress.displaytext.readingfile=Reading file {0}...",
    "# {0} - row number",
    "reading.progress.displaytext.parsingtext=Parsing row {0}"
})
public class CSVRowFactory extends ChildFactory.Detachable<CSVRow> {

    private CSVSheet key;

    public CSVRowFactory(CSVSheet key) {
        this.key = key;
    }

    @Override
    protected boolean createKeys(List<CSVRow> toPopulate) {
        assert key.getChosenFile() != null;
        new CSVFileParser(key.getChosenFile(), toPopulate).parse();
        return true;
    }

    @Override
    protected Node createWaitNode() {
        Node waitNode = super.createWaitNode();
        waitNode.setDisplayName(Bundle.waitnode_text());
        return waitNode;
    }

    @Override
    protected Node createNodeForKey(CSVRow key) {
        CSVRowNode rowNode = new CSVRowNode(key);
        return rowNode;
    }

    private class CSVFileParser implements Runnable, Cancellable, TaskListener {

        private final FileObject csvFileToReadFrom;
        private final RequestProcessor processor;
        private final List<CSVRow> toPopulate;
        private boolean cancelled = false;
        private ProgressHandle progressHandle ;
        private CSVFileParser(FileObject chosenFile, List<CSVRow> toPopulate) {
            this.csvFileToReadFrom = chosenFile;
            this.toPopulate = toPopulate;
            processor = new RequestProcessor(getClass().getCanonicalName(), 1, true);
        }

        public void parse() {
            progressHandle = ProgressHandleFactory.createHandle("", this);
            RequestProcessor.Task task = processor.create(this);
            task.addTaskListener(this);
            task.schedule(0);
        }

        @Override
        public void run() {
            progressHandle.setDisplayName(Bundle.reading_progress_displaytext_readingfile(FileUtil.getFileDisplayName(csvFileToReadFrom)));
            progressHandle.start();
            BufferedReader in = null;
            try {
                File file = FileUtil.toFile(key.getChosenFile());
                in = new BufferedReader(new FileReader(file));
                CSVReader reader = new CSVReader(in);
                List<String[]> data = reader.readAll();
                progressHandle.switchToDeterminate(0);
                int numrows = data.size();
                for (int i = 0; i < data.size(); i++) {
                    if (cancelled) {
                        break;
                    }
                    String displayName = Bundle.reading_progress_displaytext_parsingtext(i);
                    progressHandle.progress(displayName, computePercentage(i, numrows));
                    String[] datum = data.get(i);
                    CSVRow row = new CSVRow(datum, i);
                    toPopulate.add(row);
                }
            } catch (FileNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }

        }

        @Override
        public boolean cancel() {
            cancelled = true;
            progressHandle.finish();
            return cancelled;
        }

        @Override
        public void taskFinished(Task task) {
            progressHandle.finish();
        }

        private int computePercentage(int i, int numrows) {
            return (i * 100) / numrows;
        }

    }

}