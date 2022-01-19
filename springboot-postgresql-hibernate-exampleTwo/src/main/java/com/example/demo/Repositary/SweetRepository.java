package com.example.demo.Repositary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.SweetsList;
@Repository
public interface SweetRepository extends JpaRepository<SweetsList,Long> 
{

	//Object findSweetsByOffer(Integer offer);


	//Object findByOffer(Integer offer);

}
