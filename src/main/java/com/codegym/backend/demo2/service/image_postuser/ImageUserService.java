package com.codegym.backend.demo2.service.image_postuser;

import com.codegym.backend.demo2.model.entity.ImagePostUser;
import com.codegym.backend.demo2.repository.IImagePostUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ImageUserService implements IImageUserService{
    @Autowired
    private IImagePostUserRepository iImagePostUserRepository;


    @Override
    public Page<ImagePostUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<ImagePostUser> findById(Long id) {
        return iImagePostUserRepository.findById(id);
    }

    @Override
    public ImagePostUser save(ImagePostUser imagePostUser) {
        return iImagePostUserRepository.save(imagePostUser);
    }

    @Override
    public void deleteById(Long id) {
        iImagePostUserRepository.deleteById(id);
    }


    @Override
    public ImagePostUser[] listImage(Long postUser) {
        return iImagePostUserRepository.listImage(postUser);
    }
}
