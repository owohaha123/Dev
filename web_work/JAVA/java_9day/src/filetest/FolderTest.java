package filetest;

import java.io.File;

public class FolderTest {
    public static void main(String[] args) {
        // 폴더 생성
        //makeFolder();
        // 폴더 정보보기
        //folderInfo();
        // 폴더 변경 : 파일 이름변경 및 경로변경과 동일
        // 폴더 삭제
        deleteFolder();
    }

    private static void deleteFolder() {
        String path = "testfolder";

        File folder = new File(path);

        if(folder.exists()){
            // 먼저 폴더 내부의 파일 및 폴더 삭제
            File[] list = folder.listFiles();

            for(File f : list){
                f.delete(); // 내부 파일/폴더 삭제
            }

            // 최종 목적 폴더 삭제
            if(folder.delete()){
                System.out.println("삭제 성공");
            }else{
                System.out.println("삭제 실패");
            }
        }
        else{
            System.out.println("폴더 없음");
        }
    }// deleteFolder end


    private static void folderInfo() {
        String path = "testfolder";

        File folder = new File(path);

        if(folder.exists()){
            // 폴더 내부에 저장된 파일 목록 가져오기 : listFiles()
            File[] list = folder.listFiles();

            // 파일명만 출력
            for(File f : list){
                if(f.isFile()){
                    System.out.println(f.getName() + " <-파일");
                }else{
                    System.out.println(f.getName() + " <-폴더");
                }
            } // for end
        }
    } // folderInfo end

    private static void makeFolder(){
        String path = "testfolder";

        File folder = new File(path);

        if(!folder.isDirectory()){
            if(folder.mkdir()){ // 폴더 생성 메소드 mkdir()
                System.out.println("생성 성공");
            }else{
                System.out.println("생성 실패");
            }
        }// if end
        else{
            System.out.println("폴더 존재함");
        }

    } // makeFolder end
}// class end
