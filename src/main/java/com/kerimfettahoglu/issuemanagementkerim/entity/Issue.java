package com.kerimfettahoglu.issuemanagementkerim.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Issue extends BaseEntity {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "details", length = 4000)
    private String details;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Enumerated(value = EnumType.STRING)
    private IssueState issueState;
    @JoinColumn(name = "assignee_personal_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Personal assignee;
    @JoinColumn(name = "project_issue_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    private Project project;
}
