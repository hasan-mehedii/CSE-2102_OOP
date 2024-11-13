import java.util.Scanner;

class Application{
    String name;
    String file;

    Application(String file, String name){
        this.file = file;
        this.name = name;
    }

    void play(String name){
        System.out.println(name + " opened. Media is playing");
    }

    void sound(String name){
        System.out.println(name + " opened. You are changing sound");
    }
}

class ExtensionCheck{
    private String filename;

    ExtensionCheck(String filename){
        this.filename = filename;
    }

    public int checkfile(){
        if(filename.endsWith(".mp3") || filename.endsWith(".wav")){
            return 1;
        }
        else if(filename.endsWith(".mp4") || filename.endsWith(".mkv") || filename.endsWith(".webm")){
            return 2;
        }
        else
            return 0;
    }
}

class checkforapp{
    int check;
    String file;

    checkforapp(int check, String file){
        this.check = check;
        this.file = file;
    }

    void openapp(){
        if(check == 1){
            //code for audio app
            Application AudioPlayer = new Application(file, "Audio Player");
            if(file.endsWith(".mp3")){
                AudioPlayer.play("Mp3 AudioPlayer");
            }
            else if(file.endsWith(".wav")){
                AudioPlayer.play("Wav AudioPlayer");
            }
        }
        else if(check == 2){
            //code for video app

            Application VideoPlayer = new Application(file, "Video Player");
            if(file.endsWith(".mp4")){
                VideoPlayer.play("Mp4 VideoPlayer");
            }
            else if(file.endsWith(".mkv")){
                VideoPlayer.play("Mkv VideoPlayer");
            }
            else if(file.endsWith(".webm")){
                VideoPlayer.play("Webm VideoPlayer");
            }
        }
        else{
            //others app
            System.out.println("You need other App");
        }
    }
}

public class CD{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the filename: ");
        String fname = scanner.nextLine();

        ExtensionCheck extc = new ExtensionCheck(fname);
        checkforapp capp = new checkforapp(extc.checkfile(), fname);
        capp.openapp();

        scanner.close();
    }
}

