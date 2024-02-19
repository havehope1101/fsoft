package ioFile;

import java.io.IOException;
import java.util.List;

public interface IOFile<E> {
    void writerFile(List<E> eList) throws IOException;

    List<E> readerFile() throws IOException;
}
