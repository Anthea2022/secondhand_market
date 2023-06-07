package anthea.secondhand_market.dao;

import anthea.secondhand_market.domain.Admin;

/**
 * @author anthea
 * @date 2023/6/6 13:36
 */
public interface AdminMapper {
    Admin verifyByPassword(String name, String password);
}
