package com.andistoev.optlockingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void incrementAmount(String id, int amount) {
        Item item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        item.setAmount(item.getAmount() + amount);
    }

}
