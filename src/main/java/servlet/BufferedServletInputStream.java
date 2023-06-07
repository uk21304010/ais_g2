package servlet;

import java.io.ByteArrayInputStream;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

public class BufferedServletInputStream extends ServletInputStream {

    private ByteArrayInputStream inputStream;

    public BufferedServletInputStream(byte[] buffer) {
        this.inputStream = new ByteArrayInputStream( buffer );
    }

    @Override
    public int available() {
        return inputStream.available();
    }

    @Override
    public int read() {
        return inputStream.read();
    }

    @Override
    public int read(byte[] b, int off, int len) {
        return inputStream.read( b, off, len );
    }

    @Override
    public boolean isFinished() {
        return available() == 0;
    }

    @Override
    public boolean isReady() {
        return true;
    }

    @Override
    public void setReadListener(ReadListener listener) {
        throw new RuntimeException("Not implemented");
    }
}
