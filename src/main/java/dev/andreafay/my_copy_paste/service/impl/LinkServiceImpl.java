package dev.andreafay.my_copy_paste.service.impl;

import dev.andreafay.my_copy_paste.model.Link;
import dev.andreafay.my_copy_paste.model.User;
import dev.andreafay.my_copy_paste.repository.LinkRepository;
import dev.andreafay.my_copy_paste.repository.UserRepository;
import dev.andreafay.my_copy_paste.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    LinkRepository linkRepository;

    @Override
    public String addLinkToUser(String email, String linkName, String linkUrl) {
        System.out.println(email);
        Optional<User> optionalUser = userRepository.findById(email);
        if(optionalUser.isEmpty()){
            return "User not found";
        }

        User user = optionalUser.get();

        Link newLink = new Link();
        newLink.setName(linkName);
        newLink.setUrl(linkUrl);
        newLink.setUser(user);

        linkRepository.save(newLink);
        return "Link added successfully!";
    }

    @Override
    public List<Link> getUserLinksByEmail(String email) {
        System.out.println(email);
        Optional<User> optionalUser = userRepository.findById(email);
        if(optionalUser.isEmpty()){
            System.out.println("User not found");
            return null;
        }

        User user = optionalUser.get();

        return linkRepository.findByUserEmail(user.getEmail());
    }

}
