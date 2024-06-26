package br.com.doctrina.spring.support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICrudRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
