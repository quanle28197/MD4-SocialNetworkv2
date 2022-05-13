package com.codegym.backend.demo2.service.like_postUser;

import com.codegym.backend.demo2.model.entity.LikePostUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LikePostUserService implements ILikePostUserService{
    @Override
    public Page<LikePostUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<LikePostUser> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public LikePostUser save(LikePostUser likePostUser) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<LikePostUser> findLikePostUserByUserInfoIdAndPostUserId(Long userInfoId, Long postUserId) {
        return Optional.empty();
    }

    @Override
    public List<LikePostUser> totalLikeByPost(Long postUserId) {
        return null;
    }
//    @Autowired
//    private ILikePostUserRepository likePostUserRepository;
//
//    @Override
//    public Page<LikePostUser> findALl(Pageable pageable) {
//        return likePostUserRepository.findAll(pageable);
//    }
//
//    @Override
//    public Optional<LikePostUser> findById(Long id) {
//        return likePostUserRepository.findById(id);
//    }
//
//    @Override
//    public LikePostUser save(LikePostUser likePostUser) {
//        return likePostUserRepository.save(likePostUser);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        likePostUserRepository.deleteById(id);
//    }
//
//    @Override
//    public List<LikePostUser> findAll() {
//        return likePostUserRepository.findAll();
//    }
//
//    @Override
//    public Optional<LikePostUser> findLikePostUserByUserInfoIdAndPostUserId(Long userInfoId, Long postUserId) {
//        return likePostUserRepository.findLikePostUserByUserInfoIdAndPostUserId(userInfoId, postUserId);
//    }
//
//    @Override
//    public List<LikePostUser> totalLikeByPost(Long postUserId) {
//        return likePostUserRepository.totalLikeByPost(postUserId);
//    }
}
