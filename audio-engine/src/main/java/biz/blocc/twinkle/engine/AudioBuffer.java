package biz.blocc.twinkle.engine;

public class AudioBuffer {

    private int numChannels;
    private int length;
    private double[][] data;

    public AudioBuffer() {
        numChannels = 2;
        length = 512;
        data = new double[2][512];
    }

    public int getNumChannels() {
        return numChannels;
    }

    public void setNumChannels(int numChannels) {
        if (this.numChannels == numChannels) {
            return;
        }

        this.numChannels = numChannels;
        reAllocateData();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (this.length == length) {
            return;
        }

        this.length = length;
        reAllocateData();
    }

    public double[][] getData() {
        return data;
    }

    ////////////////////////////////////////////////////////////////////////////////
    /////// END OF PUBLIC
    ////////////////////////////////////////////////////////////////////////////////

    private void reAllocateData() {
        data = new double[numChannels][length];
    }

}
