package com.kerimfettahoglu.issuemanagementkerim.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

//Otomatik olarak field ların getter ve setter larının oluşturur
@Data
//Bu sınıfın super sınıf olarak alınmasının sağlar.
@MappedSuperclass
//Sınıfı diske veya network e basmak için Serializable yaptık.
//Sınıf sadece diper veritabanı nesnelerine kalıtım vermek için oluşturulduğundan abstract yapıldı.
public abstract class BaseEntity implements Serializable {
    @Column(name = "created_by",length = 100)
    private String createdBy;
    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "updated_by", length = 100)
    private String updatedBy;
    @Column(name="updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
}
