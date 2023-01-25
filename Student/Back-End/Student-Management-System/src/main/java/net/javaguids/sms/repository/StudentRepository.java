package net.javaguids.sms.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguids.sms.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long>{

}
