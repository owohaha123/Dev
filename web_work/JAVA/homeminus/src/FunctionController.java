import java.util.ArrayList;

public class FunctionController {
    // 입출력 장치 인스턴스화
    private InOutClass io = new InOutClass();
    // 상품정보 저장 공간
    ArrayList<FunctionInfo> book = new ArrayList<>();

//---------------------- 전체 제어 메소드 (run) ------------------------
    public void run(){
        // 메뉴 번호 저장 변수
        int menu = -1;
        // 타이틀 출력
        io.twoPrint("✨HomeMinus 상품 관리 프로그램✨");
        io.twoPrint("=============================");

        while (true){
            // 메뉴 출력
            menuShow();

            menu = io.inNum("입력 > ");

            if(menu == 0){
                io.twoPrint("프로그램 종료");
                break;
            }
            // 메뉴 번호에 따라 기능 처리
            switch (menu){
                case 1: // 입력 메소드 실행
                    inputData();
                    break;
                case 2: // 출력 메소드 실행
                    outputData();
                    break;
                case 3: // 검색 메소드 실행
                    searchData();
                    break;
                case 4: // 수정 메소드 실행
                    updateData();
                    break;
                case 5: // 삭제 메소드 실행
                    deleteData();
                    break;
                default:
                    io.twoPrint("0~5번까지 입력하세요");
            }
        }// while end
    } // run end

// ---------------------- 메뉴 출력 메소드 (menuShow) -----------------------
    private void menuShow(){
        io.twoPrint("1. 상품정보 입력");
        io.twoPrint("2. 상품정보 출력");
        io.twoPrint("3. 상품정보 검색");
        io.twoPrint("4. 상품정보 수정");
        io.twoPrint("5. 상품정보 삭제");
        io.twoPrint("0. 종료");
    }

// ---------------------- 기능별 메소드  -----------------------
// ----------- 1. 입력 (inputData) -----------
    private void inputData(){
        io.twoPrint("---상품정보 입력---");
        io.twoPrint("-----------------");
        // 한 개 분의 상품정보 생성
        FunctionInfo fInfo = new FunctionInfo();
        fInfo.setName(io.inStr("상품명 : "));
        fInfo.setInfo(io.inStr("상품정보 : "));
        fInfo.setCompany(io.inStr("제조사 : "));
        fInfo.setPrice(io.inNum("가격 : "));
        fInfo.setQuantity(io.inNum("수량 : "));

        // 상품정보 목록에 정보 추가
        book.add(fInfo);
        io.twoPrint("입력 완료 \n");
    }

// ----------- 2. 출력 (outputData) -----------
    private void outputData(){
        // 저장된 정보가 있는지 확인
        if(book.size() == 0){
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }
        io.twoPrint("--- 상품정보 출력 ---");
        io.twoPrint("-------------------");
        for(FunctionInfo f : book){
            io.twoPrint("상품명 : " + f.getName());
            io.twoPrint("상품정보 : " + f.getInfo());
            io.twoPrint("제조사 : " + f.getCompany());
            io.twoPrint("가격 : " + f.getPrice());
            io.twoPrint("수량 : " + f.getQuantity());
            io.twoPrint("------------------------");
        }
        io.twoPrint("출력 완료 \n");
    }

// ----------- 3. 검색 (outputData) ----------
    private void searchData() {
        if(book.size() == 0){
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }
        io.twoPrint("--- 상품정보 검색 ---");
        io.twoPrint("----------------");
        String sname = io.inStr("검색할 상품명 : ");
        // 2. 목록에서 입력받은 키워드와 같은 데이터를 비교
        for(FunctionInfo f : book){
            if(sname.equals(f.getName())){
                io.twoPrint("상품명 : " + f.getName());
                io.twoPrint("상품정보 : " + f.getInfo());
                io.twoPrint("제조사 : " + f.getCompany());
                io.twoPrint("가격 : " + f.getPrice());
                io.twoPrint("수량 : " + f.getQuantity());
                io.twoPrint("검색 완료 \n");
                return; // method 를 멈춤
            }
        }
        // 다음 문장은 검색결과가 없을 경우에만 실행
        io.twoPrint("찾는 상품이 없습니다 \n");
    }

// ----------- 4. 수정 (updateData) ----------
    private void updateData() {
        if(book.size() == 0){
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }
        io.twoPrint("--- 상품정보 수정 ---");
        io.twoPrint("-------------------");

        // 수정할 데이터 검색
        String sname = io.inStr("수정할 상품명 : ");
        int i; // 일부러 바깥쪽에서 선언
        FunctionInfo f = null;
        for(i = 0; i<book.size(); i++){
            f = book.get(i); //get: ArrayList 복사하여 에서 꺼내오는 메소드
            if(sname.equals(f.getName())){
                io.twoPrint("상품명 : " + f.getName());
                io.twoPrint("상품정보 : " + f.getInfo());
                io.twoPrint("제조사 : " + f.getCompany());
                io.twoPrint("가격 : " + f.getPrice());
                io.twoPrint("수량 : " + f.getQuantity());
                break; // for(루프)만 멈춤
            }// if end
        }// for end
        // 검색 결과가 없을 경우의 처리
        if(i == book.size()){
            io.twoPrint("검색 결과가 없습니다.");
            return; // 메소드 종료
        }

        // 검색 결과의 연락처 수정 (연락처, 생일, 나이)
        // 통상적으로 이름은 수정하지 않음
        // 아무것도 입력하지 않고 '엔터'를 치면 수정 안 함
        io.twoPrint("수정할 내용이 없으면 엔터를 누르시오");
        String ustr = io.inStr("상품명 : ");
        if(!ustr.equals("")){ // 수정할 값을 입력했는가?
            f.setName(ustr); // 지정(검색한) 상품명 변경
        }
        ustr = io.inStr("상품정보 : ");
        if(!ustr.equals("")){
            f.setInfo(ustr);
        }
        ustr = io.inStr("제조사 : ");
        if(!ustr.equals("")){
            f.setCompany(ustr);
        }
        int a = io.inNum("가격 : ");
        if(a != -1){
            f.setPrice(a);
        }
        int b = io.inNum("수량 : ");
        if(b != -1){
            f.setQuantity(b);
        }

        io.twoPrint("수정 완료 \n");
    } // updateData end

// ----------- 5. 삭제 (deleteData) ----------
    private void deleteData() {
        if(book.size() == 0){
            io.twoPrint("정보가 없습니다 \n");
            return; // 메소드 종료
        }
        io.twoPrint("--- 상품 삭제 ---");
        io.twoPrint("-----------------");

        String sname = io.inStr("삭제할 상품명 : ");
        int i; // 일부러 바깥쪽에서 선언
        FunctionInfo f = null;
        for(i = 0; i<book.size(); i++){
            f = book.get(i); //get: ArrayList 복사하여 에서 꺼내오는 메소드
            if(sname.equals(f.getName())){
                io.twoPrint("상품명 : " + f.getName());
                io.twoPrint("상품정보 : " + f.getInfo());
                io.twoPrint("제조사 : " + f.getCompany());
                io.twoPrint("가격 : " + f.getPrice());
                io.twoPrint("수량 : " + f.getQuantity());
                break; // for(루프)만 멈춤
            }// if end
        }// for end
        // 검색 결과가 없을 경우의 처리
        if(i == book.size()){
            io.twoPrint("검색 결과가 없습니다.");
            return; // 메소드 종료
        }

        // 삭제할 상품명 검색 성공
        String yn = io.inStr("삭제할까요?(y)");

        if(yn.equals("y")){ // 입력값이 "y"라면
            book.remove(f); // i 를 넣어도 됨
            io.twoPrint("삭제 완료 \n");
            return;
        }
        // 입력값이 "y"가 아니라면
        io.twoPrint("삭제 취소 \n");
    }

} // FunctionController end
