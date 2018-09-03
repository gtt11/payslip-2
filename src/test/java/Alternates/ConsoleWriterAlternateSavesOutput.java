package Alternates;

import Console.Writer.ConsoleWriter;

public class ConsoleWriterAlternateSavesOutput implements ConsoleWriter {

    private String savedOutput;

    @Override
    public void display(String text) {
        savedOutput += text;
    }

    public boolean outputIncludes(String text) {
        return savedOutput.contains(text);
    }

}
