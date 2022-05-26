package com.nhnacademy.springjpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "file")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_no", nullable = false)
    private Integer no;
    @Column(name = "file_name", nullable = false)
    private String name;
    @Column(name = "file_path", nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn(name = "post_no", nullable = false)
    private Post post;
}
