package com.tdnhat.bookstore.book.entity;

import com.tdnhat.bookstore.user.entity.User;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "bill_code", length = 14, nullable = false)
    private String billCode;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullname;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phone_number", length = 11, nullable = false)
    private String phoneNumber;

    @Column(length = 200, nullable = false)
    private String address;

    @Column(name = "note",length = 200)
    private String note;

    @Builder.Default
    @Column(name = "order_time", nullable = false)
    private LocalDateTime createdTime = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    @ToString.Exclude
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}