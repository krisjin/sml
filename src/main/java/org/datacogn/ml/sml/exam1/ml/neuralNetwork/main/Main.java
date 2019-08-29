package org.datacogn.ml.sml.exam1.ml.neuralNetwork.main;


import org.datacogn.ml.sml.exam1.ml.neuralNetwork.ui.MainFrame;

public class Main {
    //the main function of whole project
    public static void main(String[] args){
       /* String folderName = System.getProperty("java.io.tmpdir");
        //create training data store path
        String trainFolder = folderName + "/digital_recognizer_train";
        File folder = new File(trainFolder);
        if(!folder.isDirectory()){
            folder.mkdir();
        }
        Constant.trainFolder = trainFolder;
*/
        new MainFrame();
    }
}
