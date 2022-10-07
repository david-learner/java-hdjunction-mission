# 환자 관리 시스템
## 시스템 개요
병원 내원 환자를 관리하는 시스템입니다. 주요 기능은 환자 정보의 등록, 변경, 검색입니다.

## 기능 구현 목록
### 병원 (Hospital)
- 병원 정보 조회
- 병원 정보 등록
- 병원 정보 수정
- 병원 정보 삭제
### 환자 (Patient)
- [x] 환자 조회 (단건)
    - 환자 id를 이용해 한 명의 환자 정보를 조회할 수 있다.
    - 환자 조회시 내원 정보도 함께 제공되어야 한다.
- [x] 환자 목록 조회
    - 전체 환자 목록을 조회할 수 있다
        - 목록은 이름, 환자등록번호, 성별, 생년월일, 휴대전화, 최근방문일을 포함한다.
- 환자 목록 조회 확장 - 검색
    - 이름, 환자등록번호, 생년월일을 조건으로 하여 환자 정보를 검색할 수 있다.
    - 환자 정보가 존재하지 않는 경우  검색 결과가 없음을 알려주어야 한다.
        - 검색 결과 없음 메시지: 검색결과가 없습니다.
- 환자 목록 조회 확장 - 페이지네이션
    - pageSize(한 번에 조회하는 최대 항목 수), pageNo (1부터 시작, 페이지 번호)를 전달받아 결과를 전달한다.
    - 검색 조건과 별개로 동작해야 한다.
- [x] 환자 정보 등록
    - 환자등록번호는 병원별로 중복되지 않아야 한다.
- [x] 환자 정보 수정
- [x] 환자 정보 삭제
### 환자 방문 (Visit)
- [x] 환자 방문기록 조회
- [x] 환자 방문기록 등록
    - 환자 방문기록 등록을 위해서 병원 정보와 환자 정보가 필요합니다.
- [x] 환자 방문기록 수정
- [x] 환자 방문기록 삭제
### 코드 (CodeGroup, Code)