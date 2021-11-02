package demo5;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {


        int c;
        InputStream in=new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("D:\\github\\design-pattern-demo\\chapter3-demo\\src\\main\\resources\\test.txt")));
        while ((c=in.read())>=0){
            System.out.print((char)c);
        }
        in.close();
    }
}

class LowerCaseInputStream extends FilterInputStream{

    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException {
        int c = super.read();
        return (c==-1?c:Character.toLowerCase((char)c));
    }

    public int read(byte[] b,int offset,int len) throws IOException {

        //总读取了多少个字节数
        int result=super.read(b,offset,len);

        //从offset开始进行
        for (int i = offset; i < offset+result ; i++) {
            b[i]=(byte)Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
