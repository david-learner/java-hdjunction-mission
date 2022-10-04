package com.hdjunction.patient.management.api.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class ResourceLocationBuilder {

    /**
     *  현재 요청을 바탕으로 리소스 위치를 생성한다.
     *  ex) /api/patients => /api/patients/{id}
     */
    public static URI build(Long resourceId) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(resourceId).toUri();
    }
}
