package com.bookstore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "Tên quyền phải ít hơn 50 ký tự")
    @NotBlank(message = "Tên quyền không được để trống")
    @Column(name = "name",length=50, nullable=false)
    private String name;

    @Size(max = 255, message = "Mô tả quyền phải ít hơn 255 ký tự")
    @Column(name = "description",length=255)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
