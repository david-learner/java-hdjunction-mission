package com.hdjunction.patient.management.domain;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.tuple.ValueGenerator;

public class PatientRegistrationNumberGenerator implements ValueGenerator<String> {

    private static final String GET_NEXT_SEQUENCE_QUERY = "select next value for patient_registration_number_sequence";
    private static int PATIENT_REGISTRATION_NUMBER_LENGTH = 13;

    @Override
    public String generateValue(Session session, Object owner) {
        NativeQuery query = session.createNativeQuery(GET_NEXT_SEQUENCE_QUERY);
        query.setHibernateFlushMode(FlushMode.COMMIT);
        Object sequence = query.getSingleResult();
        return padLeftZeros(sequence.toString(), PATIENT_REGISTRATION_NUMBER_LENGTH);
    }

    /**
     * 부족한 길이만큼 0을 왼쪽부터 채운다.
     *
     * @param source
     * @param length
     * @return
     */
    public String padLeftZeros(String source, int length) {
        int sourceLength = source.length();

        if (sourceLength >= length) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - sourceLength) {
            sb.append('0');
        }
        sb.append(source);

        return sb.toString();
    }
}