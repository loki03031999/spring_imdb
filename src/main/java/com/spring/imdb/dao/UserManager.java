package com.spring.imdb.dao;

import com.mysql.cj.util.StringUtils;
import com.spring.imdb.entity.User;
import com.spring.imdb.exceptions.DataException;
import com.sun.istack.NotNull;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.UUID;

@Data
@Component
@Transactional
public class UserManager {

    Logger logger = LoggerFactory.getLogger(UserManager.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * Fetches User object from Database using rawId.
     * @param id
     * @return
     */
    public User getUserById(@NotNull Long id) {
        try {
            return userRepository.findById(id).orElseThrow();
        }
        catch (NoSuchElementException nse) {
            logger.info("User with id: {} does not exist", id);
            DataException.throwError(DataException.DataExceptionErrorCode.NO_SUCH_ELEMENT_EXCEPTION);
        }
        catch (Exception e) {
            logger.error("Error while fetching user with userId: {}", id);
            DataException.throwError();
        }
        return null;
    }


    /**
     * Fetches User object from Database using secureUserId.
     * @param secureUserId
     * @return
     */
    public User getUserBySecureUserId(String secureUserId) {
        User user = null;
        try {
            user = userRepository.getUserBySecureUserId(secureUserId).orElseThrow();
        }
        catch (NoSuchElementException nse) {
            logger.info("User with secureUserId {} does not exist", secureUserId);
            DataException.throwError(DataException.DataExceptionErrorCode.NO_SUCH_ELEMENT_EXCEPTION);
        }
        catch (Exception e) {
            logger.error("Error while fetching user with secureUserId: {}", secureUserId);
            DataException.throwError();
        }
        return user;
    }

    public User save(User user) {
        try {
            if (StringUtils.isEmptyOrWhitespaceOnly(user.getSecureUserId())) {
                user.setSecureUserId(UUID.randomUUID().toString());
            }
            return userRepository.save(user);
        }
        catch (Exception exception) {
            logger.error("Error while saving user");
            DataException.throwError();
        }
        return null;
    }

}
