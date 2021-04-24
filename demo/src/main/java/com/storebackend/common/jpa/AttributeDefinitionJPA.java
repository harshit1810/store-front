/**
 * 
 */
package com.storebackend.common.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.storebackend.common.bean.AttributeDefinition;

/**
 * @author hsriv
 *
 */
public interface AttributeDefinitionJPA extends JpaRepository<AttributeDefinition, Long> {

}
