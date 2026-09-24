package com.campus.express.repo;
import com.campus.express.model.*; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface PackageRepository extends JpaRepository<PackageItem,Long>{ List<PackageItem> findByOwnerIdOrderByStoredAtDesc(Long ownerId); }
