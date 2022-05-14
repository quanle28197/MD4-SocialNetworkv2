/*<<<<<<< HEAD
 *//*
package com.codegym.backend.demo2.service.like_cmtPostUser;

import com.example.module4_backend.model.entity.LikeCommentPostUser;
import com.example.module4_backend.repository.ILikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeCmtPostUserService implements ILikeCmtPostUserService {
    @Autowired
    private  ILikeCommentRepository iLikeCommentRepository;
    @Override
    public Page<LikeCommentPostUser> findALl(Pageable pageable) {
        return iLikeCommentRepository.findAll(pageable);
    }

    @Override
    public Optional<LikeCommentPostUser> findById(Long id) {
        return iLikeCommentRepository.findById(id);
    }

    @Override
    public LikeCommentPostUser save(LikeCommentPostUser likeCommentPostUser) {
        return iLikeCommentRepository.save(likeCommentPostUser);
    }

    @Override
    public void deleteById(Long id) {
        iLikeCommentRepository.deleteById(id);
    }

    @Override
    public List<LikeCommentPostUser> findAll() {
        return iLikeCommentRepository.findAll();
    }

    @Override
    public Optional<LikeCommentPostUser> findLikeCommentByUser(Long cmPostUserId, Long fromUserId) {
        return iLikeCommentRepository.findLikeCommentByUser(cmPostUserId, fromUserId);
    }

    @Override
    public List<LikeCommentPostUser> listLikeComments(Long cmPostUserId) {
        return iLikeCommentRepository.listLikeComments(cmPostUserId);
    }
}
*//*
=======
//package com.codegym.backend.demo2.service.like_cmtPostUser;
//
//
//import com.codegym.backend.demo2.model.entity.LikeCommentPostUser;
//import com.codegym.backend.demo2.repository.ILikeCommentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class LikeCmtPostUserService implements ILikeCmtPostUserService {
//    @Autowired
//    private ILikeCommentRepository iLikeCommentRepository;
//    @Override
//    public Page<LikeCommentPostUser> findAll(Pageable pageable) {
//        return iLikeCommentRepository.findAll(pageable);
//    }
//
//    @Override
//    public Optional<LikeCommentPostUser> findById(Long id) {
//        return iLikeCommentRepository.findById(id);
//    }
//
//    @Override
//    public LikeCommentPostUser save(LikeCommentPostUser likeCommentPostUser) {
//        return iLikeCommentRepository.save(likeCommentPostUser);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        iLikeCommentRepository.deleteById(id);
//    }
//
//    @Override
//    public List<LikeCommentPostUser> findAll() {
//        return iLikeCommentRepository.findAll();
//    }
//
//    @Override
//    public Optional<LikeCommentPostUser> findLikeCommentByUser(Long cmPostUserId, Long fromUserId) {
//        return iLikeCommentRepository.findLikeCommentByUser(cmPostUserId, fromUserId);
//    }
//
//    @Override
//    public List<LikeCommentPostUser> listLikeComments(Long cmPostUserId) {
//        return iLikeCommentRepository.listLikeComments(cmPostUserId);
//    }
//}
>>>>>>> dev*/
