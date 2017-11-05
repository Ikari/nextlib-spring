package com.next.library.repository;

import com.next.library.model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IUsuarioRepository extends MongoRepository<Usuario, ObjectId> {
    public Usuario findUsuarioByEmail(String email);
}
