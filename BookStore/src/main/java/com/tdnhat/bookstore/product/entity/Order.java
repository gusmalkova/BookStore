package com.tdnhat.bookstore.product.entity;

import com.tdnhat.bookstore.user.entity.User;
import com.tdnhat.bookstore.util.BillCodeUtils;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
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
    @JoinColumn(name = "user_id")
    private User user;

    @Builder.Default
    @Column(name = "bill_code", length = 50, nullable = true)
    private String billCode = BillCodeUtils.generate();

    @Column(name = "full_name", length = 50, nullable = true)
    private String fullname;

    @Column(name = "email", length = 100, nullable = true)
    private String email;

    @Column(name = "phone_number", length = 20, nullable = true)
    private String phoneNumber;

    @Column(length = 200, nullable = false)
    private String address;

    @Column(name = "note", length = 200)
    private String note;

    @Builder.Default
    @Column(name = "order_time", nullable = false)
    private LocalDateTime createdTime = LocalDateTime.now();

    @Builder.Default
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