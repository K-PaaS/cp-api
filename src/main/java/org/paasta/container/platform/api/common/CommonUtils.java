package org.paasta.container.platform.api.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.paasta.container.platform.api.common.model.ResultStatus;
import org.paasta.container.platform.api.users.Users;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Common Utils 클래스
 *
 * @author hrjin
 * @version 1.0
 * @since 2020.08.26
 */
public class CommonUtils {

    /**
     * Timestamp Timezone 을 변경하여 재설정
     *
     * @param requestTimestamp the request timestamp
     * @return the string
     */
    public static String procSetTimestamp(String requestTimestamp) {
        String resultString = "";

        if (null == requestTimestamp || "".equals(requestTimestamp)) {
            return resultString;
        }

        SimpleDateFormat simpleDateFormatForOrigin = new SimpleDateFormat(Constants.STRING_ORIGINAL_DATE_TYPE);
        SimpleDateFormat simpleDateFormatForSet = new SimpleDateFormat(Constants.STRING_DATE_TYPE);

        try {
            Date parseDate = simpleDateFormatForOrigin.parse(requestTimestamp);
            long parseDateTime = parseDate.getTime();
            int offset = TimeZone.getTimeZone(Constants.STRING_TIME_ZONE_ID).getOffset(parseDateTime);

            resultString = simpleDateFormatForSet.format(parseDateTime + offset);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultString;
    }

    /**
     * 넘어온 Object의 parameter가 null 또는 ""(빈 값)인지 체크
     *
     * @param obj the obj
     * @return the Object
     */
    public static Object stringNullCheck(Object obj) {
        List<String> checkParamList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = objectMapper.convertValue(obj, Map.class);

        for(String key : map.keySet()) {
            if(!StringUtils.hasText(map.get(key))) {
                checkParamList.add(key);
            }
        }

        if(checkParamList.size() > 0) {
            return ResultStatus.builder()
                    .resultCode(Constants.RESULT_STATUS_FAIL)
                    .resultMessage("회원가입에 실패했습니다.")
                    .httpStatusCode(400)
                    .detailMessage("회원가입에 실패했습니다. " + checkParamList.toString() + " 항목을 다시 확인해주세요.").build();
        }

        return objectMapper.convertValue(map, Users.class);
    }


    public static Map yamlMatch(String username, String namespace) {
        Map<String, Object> model = new HashMap<>();
        model.put("userName", username);
        model.put("spaceName", namespace);

        return model;
    }

    /**
     * 정규 표현식에 일치하는 지 체크
     *
     * @param users the users
     * @return the String
     */
    public static String regexMatch(Users users) {
        String defaultValue = Constants.RESULT_STATUS_SUCCESS;

        boolean userIdCheck = Pattern.matches("^[a-z0-9]([-a-z0-9]*[a-z0-9])?(\\.[a-z0-9]([-a-z0-9]*[a-z0-9])?)*", users.getUserId());
        boolean passwordCheck = Pattern.matches("^[a-z]+(?=.*\\d)(?=.*[$@$!%*#?&])[a-z\\d$@$!%*#?&]{3,11}$", users.getPassword());
        boolean emailCheck = Pattern.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", users.getEmail());

        if(!userIdCheck) {
            return "User ID는 최대 253자 내의 영문 소문자 또는 숫자로 시작하고 끝나야 하며, 특수문자는 - 또는 . 만 사용 가능합니다.";
        } else if(!passwordCheck) {
            return "비밀번호는 영문으로 시작하고, 최소 하나 이상의 숫자와 특수 문자를 혼합하여 4~40자 이내로 사용 가능합니다.";
        } else if(!emailCheck) {
            return "이메일 형식이 잘못되었습니다.";
        }

        return defaultValue;
    }


    /**
     * Object List value modify
     *
     * @param obj    the obj
     * @param index  the index
     * @param newObj the newObj
     * @return       the Object List
     */
    public static Object[] modifyValue(Object[] obj, int index, Object newObj) {
        ArrayList<Object> list = new ArrayList<>(Arrays.asList(obj));
        for(int i = 0; i < list.size(); i++) {
            if(i == index) {
                list.set(index, newObj);
            }
        }
        return list.toArray();

    }
}
