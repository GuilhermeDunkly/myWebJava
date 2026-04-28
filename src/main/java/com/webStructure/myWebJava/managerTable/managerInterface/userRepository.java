package com.webStructure.myWebJava.managerTable.managerInterface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.webStructure.myWebJava.managerTable.tableMapping.User;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
  User findByUsername(String username);
}
