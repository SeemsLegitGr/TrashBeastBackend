package gr.seemslegit.trashbeastbackend.util;

import gr.seemslegit.trashbeastbackend.Service.ReadServiceImpl;

public class ReadFile {

    private static final String FILENAME = "src\\main\\resources\\testFile.txt";

    public static void main(String[] args) {

        String FILENAME = "src\\main\\resources\\testFile.txt";

        ReadServiceImpl impl = new ReadServiceImpl();

        impl.parseFile(FILENAME);


    }
}
