package com.kerimfettahoglu.issuemanagementkerim.entity;

import com.kerimfettahoglu.issuemanagementkerim.entity.BaseEntity;
import com.kerimfettahoglu.issuemanagementkerim.entity.Issue;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Personal extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "personal_id", unique = true)
    private Long id;
    @Column(name = "personal_name", unique = true, length = 50)
    private String name;
    @Column(name = "personal_password", length = 50)
    private String password;
    @Column(name = "personal_email", length = 100)
    private String email;
    @JoinColumn(name = "assignee_personal_id")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Issue> issues;
}
