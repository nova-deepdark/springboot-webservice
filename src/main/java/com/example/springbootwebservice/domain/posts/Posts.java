package com.example.springbootwebservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                 //클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor      //기본 생성자 추가 == public posts
@Entity         // 테이블과 링크 될 클래스임을 나타낸다.
public class Posts {

    @Id         // 해당 테이블의 PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //  PK의 생성 규칙을 나타낸다.
    private Long id;

    @Column(length = 500, nullable = false)         // 테이블의 칼럼을 나타내며, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder            // 해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}