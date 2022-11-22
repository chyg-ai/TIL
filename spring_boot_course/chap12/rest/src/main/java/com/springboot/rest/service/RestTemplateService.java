package com.springboot.rest.service;

import com.springboot.rest.dto.MemberDto;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpClient;

@Service
public class RestTemplateService {
    public String getName(){
        URI uri= UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api")
                .encode()
                .build() // UriComponents
                .toUri(); // UriComponents → Uri

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();
    }

    public String getNameWithPathVariable(){
        URI uri=UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api/{name}")
                .encode()
                .build() // UriComponents
                .expand("Flature")
                .toUri(); // UriComponents → Uri

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();
    }

    public String getNameWithParameter(){
        URI uri=UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api/param")
                .queryParam("name", "Flature")
                .encode()
                .build() // UriComponents
                .toUri(); // UriComponents → Uri

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.getForEntity(uri, String.class);
        return responseEntity.getBody();
    }

    public ResponseEntity<MemberDto> postWithParamAndBody(){
        URI uri=UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api")
                .queryParam("name", "Flature")
                .queryParam("email", "flature@wikibooks.co.kr")
                .queryParam("organization", "Wikibooks")
                .encode()
                .build() // UriComponents
                .toUri(); // UriComponents → Uri

        MemberDto memberDto=new MemberDto();
        memberDto.setName("flature!!");
        memberDto.setEmail("flature@gmail.com");
        memberDto.setOrganization("Around Hub Studio");

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<MemberDto> responseEntity=restTemplate.postForEntity(uri, memberDto, MemberDto.class);

        return responseEntity;
    }

    public ResponseEntity<MemberDto> postWithHeader(){
        URI uri=UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/api/v1/crud-api/add-header")
                .encode()
                .build() // UriComponents
                .toUri(); // UriComponents → Uri

        MemberDto memberDto=new MemberDto();
        memberDto.setName("flature");
        memberDto.setEmail("flature@wikibooks.co.kr");
        memberDto.setOrganization("Around Hub Studio");

        // 요청 생성
        RequestEntity<MemberDto> requestEntity=RequestEntity
                .post(uri)
                .header("my-header", "Wikibooks API")
                .body(memberDto);

        // 응답 반환
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<MemberDto> responseEntity=restTemplate.exchange(requestEntity, MemberDto.class);
        return responseEntity;
    }

    // 커스텀 RestTemplate
    public RestTemplate restTemplate(){
        HttpComponentsClientHttpRequestFactory factory=new HttpComponentsClientHttpRequestFactory();

//      HttpClient 생성 방법 1
//      HttpClient client=HttpClientBuilder.create()
//              .setMaxConnTotal(500)
//              .setMaxConnPerRoute(500)
//              .build();

//      HttpClient 생성 방법 2
        CloseableHttpClient httpClient=HttpClients.custom()
                .setMaxConnTotal(500)
                .setMaxConnPerRoute(500)
                .build();

        factory.setHttpClient(httpClient);
        factory.setConnectTimeout(2000);
        factory.setReadTimeout(5000);

        RestTemplate restTemplate=new RestTemplate(factory);

        return restTemplate;
    }
}
