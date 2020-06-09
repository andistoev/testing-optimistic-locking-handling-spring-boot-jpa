package com.andistoev.optlockingservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryService {

    private final ItemService itemService;

    @Transactional(readOnly = true)
    public void incrementProductAmount(String itemId, int amount) {
        try {
            itemService.incrementAmount(itemId, amount);
        } catch (ObjectOptimisticLockingFailureException e) {
            log.warn("Somebody has already updated the amount for item:{} in concurrent transaction. Will try again...", itemId);
            itemService.incrementAmount(itemId, amount);
        }
    }

}
