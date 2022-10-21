package com.tdnhat.bookstore.book.service;

import com.tdnhat.bookstore.book.entity.Role;
import com.tdnhat.bookstore.book.entity.User;
import com.tdnhat.bookstore.book.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Use by spring security to authenticate and authorize user
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = repository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(username, currentUser.getPassword(),
                                                                      AuthorityUtils.createAuthorityList(this.getRoles(currentUser)));
    }

    private String[] getRoles(User user) {
        return user.getRole().stream().map(Role::getName).toArray(String[]::new);
    }
}
