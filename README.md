# java-library-management

데브 코스 1~2주차 과제인 도서 관리 애플리케이션입니다.

<br>

**프로젝트 구현 사항 및 코드 리뷰**
- Pull requests [**#30**](https://github.com/prgrms-be-devcourse/java-library-management/pull/30)

<br>

**개략적인 요구사항**

- 도서 관리 애플리케이션을 만들어야합니다.
- 도서 관리 애플리케이션은 도서에 대해 다음과 같은 행동이 가능해야합니다.
    - 도서를 등록할 수 있어야합니다.
    - 도서 전체 목록을 볼 수 있어야합니다.
    - 도서 제목을 기준으로 도서를 검색할 수 있어야합니다.
    - 도서번호를 기준으로 아래 액션이 가능해야합니다.
        - 도서를 대여할 수 있어야합니다.
        - 도서를 반납할 수 있어야합니다.
        - 도서를 분실 처리할 수 있어야합니다.
        - 도서를 삭제할 수 있어야합니다.
- 도서는 다음과 같은 데이터를 가져야합니다. 또한 요구사항을 만족하기 위해 추가적인 필드가 필요하다면 여러분이 추가하셔도 됩니다.
    - 도서번호(중복되지 않아야합니다. ISBN을 사용하라는 의미가 아닙니다.)
    - 제목
    - 작가 이름
    - 페이지 수
    - 상태
        - 대여 가능
        - 대여중
        - 도서 정리중
        - 분실됨

**도서 상태 관련 요구사항**

- 도서가'대여 가능' 상태 일 때만 도서를 대여할 수 있고, 도서가 대여되면 상태를 '대여중'으로 바꿔야합니다. 도서가 '대여 가능' 상태가 아닌 경우 해당 도서를 대여할 수 없는 이유에 대해 알려줘야합니다.
- 도서가 '대여중' 상태 일 때는 도서를 반납할 수 있습니다. 이때 도서가 반납되면 도서의 상태는 '도서 정리중' 상태로 바뀌어야합니다. 그리고 '도서 정리중' 상태에서 5분이 지난 도서는 '대여 가능'으로  
  바뀌어야합니다. (대여된 후 5분이 지난 도서를 누군가 대여하려고 했을 때 대여 처리가 되어야한다는 겁니다)
- 도서를 분실 처리하면 도서는 '분실됨' 상태가 되어야합니다. 만약 분실된 도서를 찾게된 경우 반납 처리를 하면 도서를 찾은 것으로 간주합니다. 이 경우 도서를 반납하는 것과 동일한 절차가 진행되어야합니다.

**제약사항**

- 입력은 기본적으로 Console로 받습니다. 그러나 도서 정보 등록의 경우 애플리케이션이 시작할 때 여러분들이 지정한 File에서 읽어서 자동으로 등록되도록 만들어야합니다. 또한 Console로 등록한 도서는  
  File에도 저장되어 애플리케이션이 재시작 되더라도 등록된 도서가 자동으로 등록되어야합니다.
- 애플리케이션은 '테스트 모드'를 지원해야합니다. 테스트 모드에서는 파일에서 데이터를 읽거나 쓰지 않고 오직 콘솔 입력을 통해서만 데이터를 입력 받고, 저장도 List에만 저장합니다. 당연히 애플리케이션을  
  재시작하면 모든 데이터는 날아갑니다. 테스트 모드로 실행할지 일반 모드로 실행할지는 애플리케이션을 시작할 때 입력에 따라 결정됩니다.
- 도서 정보를 저장하는 파일은 CSV, JSON 등 데이터를 저장하고 조회하기 적절한 형태라면 뭐라도 좋습니다.

**테스트 코드 관련**
요구사항을 잘 만족하고 있는지 보여줄 수 있는 테스트 코드를 작성해야합니다.\  
위와 같은 요구사항을 보지 못한 사람이 테스트 코드만 보더라도 해당 애플리케이션이 가지고 있는 요구사항을 파악할 수 있도록 작성하는게 좋습니다.\  
여기에 부합한다고 생각되는 테스트 코드들을 마음껏 작성해보세요.

**모드 선택 예시**

```  
Q. 모드를 선택해주세요.  
1. 일반 모드  
2. 테스트 모드  
  
> 1  
  
[System] 일반 모드로 애플리케이션을 실행합니다.  
```  

**모드 진입 후 선택 화면 예시**

```  
Q. 사용할 기능을 선택해주세요.  
1. 도서 등록  
2. 전체 도서 목록 조회  
3. 제목으로 도서 검색  
4. 도서 대여  
5. 도서 반납  
6. 도서 분실  
7. 도서 삭제  
  
>  
```  

**도서 등록 예시**

```  
(메뉴에서 1번 선택시)  
  
> 1  
  
[System] 도서 등록 메뉴로 넘어갑니다.  
  
Q. 등록할 도서 제목을 입력하세요.  
  
> 스킨 인 더 게임  
  
Q. 작가 이름을 입력하세요.  
  
> 나심 탈레브  
  
Q. 페이지 수를 입력하세요.  
  
> 444  
  
[System] 도서 등록이 완료되었습니다.  
  
(메뉴 다시 노출)  
```  

**전체 도서 목록 조회**

```  
(메뉴에서 2번 선택시)  
  
> 2  
  
[System] 전체 도서 목록입니다.  
  
도서번호 : 1제목 : 위기의 역사  
작가 이름 : 오건영  
페이지 수 : 480 페이지  
상태 : 대여중  
  
------------------------------  
  
도서번호 : 2제목 : 스킨 인 더 게임  
작가 이름 : 나심 탈레브  
페이지 수 : 444 페이지  
상태 : 대여 가능  
  
------------------------------  
  
도서번호 : 3제목 : 이것이 취업을 위한 OOO다  
작가 이름 : 이준형  
페이지 수 : 821 페이지  
상태 : 대여 가능  
  
------------------------------  
  
[System] 도서 목록 끝  
  
(메뉴 다시 노출)  
```  

**도서 제목으로 검색 예시**

```  
(메뉴에서 3번 선택시)  
  
> 3  
  
[System] 제목으로 도서 검색 메뉴로 넘어갑니다.  
  
Q. 검색할 도서 제목 일부를 입력하세요.  
  
> 게임  
  
도서번호 : 2제목 : 스킨 인 더 게임  
작가 이름 : 나심 탈레브  
페이지 수 : 444 페이지  
상태 : 대여 가능  
  
------------------------------  
  
[System] 검색된 도서 끝  
  
(메뉴 다시 노출)  
```  

**도서 대여 예시 (대여 성공)**

```  
(메뉴에서 4번 선택시)  
  
> 4  
  
[System] 도서 대여 메뉴로 넘어갑니다.  
  
Q. 대여할 도서번호를 입력하세요  
  
> 3  
  
[System] 도서가 대여 처리 되었습니다.  
  
(메뉴 다시 노출)  
```  

**도서 대여 예시 (대여 실패)**

```  
(메뉴에서 4번 선택시)  
  
> 4  
  
[System] 도서 대여 메뉴로 넘어갑니다.  
  
Q. 대여할 도서번호를 입력하세요  
  
> 1  
  
[System] 이미 대여중인 도서입니다.  
  
(메뉴 다시 노출)  
```  

*) 정리중이거나 분실된 도서도 대여 불가능하다는 메시지가 나와야합니다.

**도서 반납 예시 (반납 성공)**

```  
(메뉴에서 5번 선택시)  
  
> 5  
  
[System] 도서 반납 메뉴로 넘어갑니다.  
  
Q. 반납할 도서번호를 입력하세요  
  
> 1  
  
[System] 도서가 반납 처리 되었습니다.  
  
(메뉴 다시 노출)  
```  

**도서 반납 예시 (반납 실패)**

```  
(메뉴에서 4번 선택시)  
  
> 4  
  
[System] 도서 대여 메뉴로 넘어갑니다.  
  
Q. 대여할 도서번호를 입력하세요  
  
> 2  
  
[System] 원래 대여가 가능한 도서입니다.  
  
(메뉴 다시 노출)  
```  

**도서 분실 처리 예시 (분실 처리 성공)**

```  
(메뉴에서 6번 선택시)  
  
> 6  
  
[System] 도서 분실 처리 메뉴로 넘어갑니다.  
  
Q. 분실 처리할 도서번호를 입력하세요  
  
> 1  
  
[System] 도서가 분실 처리 되었습니다.  
  
(메뉴 다시 노출)  
```  

**도서 분실 처리 예시 (분실 처리 실패)**

```  
(메뉴에서 6번 선택시)  
  
> 6  
  
[System] 도서 분실 처리 메뉴로 넘어갑니다.  
  
Q. 분실 처리할 도서번호를 입력하세요  
  
> 1  
  
[System] 이미 분실 처리된 도서입니다.  
  
(메뉴 다시 노출)  
```  

**도서 삭제 예시 (삭제 처리 성공)**

```  
(메뉴에서 7번 선택시)  
  
> 7  
  
[System] 도서 삭제 처리 메뉴로 넘어갑니다.  
  
Q. 삭제 처리할 도서번호를 입력하세요  
  
> 1  
  
[System] 도서가 삭제 처리 되었습니다.  
  
(메뉴 다시 노출)  
```  

**도서 삭제 예시 (삭제 처리 실패)**

```  
(메뉴에서 7번 선택시)  
  
> 7  
  
[System] 도서 삭제 처리 메뉴로 넘어갑니다.  
  
Q. 삭제 처리할 도서번호를 입력하세요  
  
> 1  
  
[System] 존재하지 않는 도서번호 입니다.  
  
(메뉴 다시 노출)  
```
