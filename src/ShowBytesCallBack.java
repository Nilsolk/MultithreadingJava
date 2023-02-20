import java.io.PrintStream;

interface ShowBytesCallBack {
    void updateValue(int value);

    class Base implements ShowBytesCallBack {
        private int total = 0;

        public void totalBytes(PrintStream stream) {
            stream.println(total);
        }

        @Override
        public void updateValue(int value) {
            total += value;
        }
    }
}
