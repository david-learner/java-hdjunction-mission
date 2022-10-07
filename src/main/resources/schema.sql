/* 환자등록번호 채번용 시퀀스 */
drop sequence if exists patient_registration_number_sequence;
create sequence patient_registration_number_sequence minvalue 1 maxvalue 9999999999999 increment by 1;
