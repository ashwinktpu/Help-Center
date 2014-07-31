/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ekshiksha.helpcenter.process;

/**
 *
 * @author rkjangir
 */
import org.ekshiksha.helpcenter.beans.*;
import java.sql.*;
import ekalavya.helper.EkShikshaDBConnection;
import java.util.*;

public class EContentMenuHelper {

    private static ArrayList getCategory(ArrayList topics, int parent_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //declaring class variables

    private static ArrayList getCategory(int parentid, int parentid0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Connection con; // to store the database connection object
    private PreparedStatement pstmt, pstmt1; // to store the prpearedstatement object
    private Statement stmt; //to store the statement object
    private ResultSet res, res1; //to store the result set

    //declaring the constructor of the class
    public EContentMenuHelper() {
        //con = EkShikshaDBConnection.getDBConnection();
    }

    public EContentMenuHelper(Connection con) {
        this.con = con;
    }
    /*
     * The getAvailablieLanguage() function returns the list of available
     * language * It returns a list of type LanguageBean. * LanguageBean has
     * language id, language name and description * If no language found, this
     * method returns empty list.
     */
    
    /*

    public ArrayList getAvailableLanguage() {
        ArrayList langList = new ArrayList();
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                pstmt = con.prepareStatement("SELECT * FROM languages ORDER By lang_id");
                res = pstmt.executeQuery();
                while (res.next()) {
                    LanguageBean lBean = new LanguageBean();
                    lBean.setLanguageId(res.getInt("lang_id"));
                    lBean.setLanguageName(res.getString("lang_name"));
                    lBean.setDescription(res.getString("lang_desc"));
                    langList.add(lBean);
                }
                return langList;
            } catch (SQLException sqle) {
                System.out.println(sqle);
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeDBConnection(con);
            }

        }
        return langList;
    }

    /*
     * getAllCategorys method is used for retreiving all topics available for
     * particular language It takes a parameter language id (langId). It returns
     * a list of Categorys for particular language. If no Category found, the function
     * returns a empty list.
     */
    
    
    /*
    public ArrayList getAllCategorys(int langId) {
        ArrayList topicList = new ArrayList();
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                pstmt = con.prepareStatement("select topics.topic_id,contents.topic_name,topics.parent_id,topics.type from topics inner join contents on (topics.topic_id = contents.topic_id) where contents.lang_id=? or contents.lang_id=1 order by contents.topic_id, contents.lang_id desc;");
                pstmt.setInt(1, langId);
                res = pstmt.executeQuery();
                int currentCategoryId = 0;
                while (res.next()) {
                    Category topic = new Category();
                    if (currentCategoryId == 0) {
                        topic.setCategoryId(res.getInt("topic_id"));
                        topic.setCategoryName(res.getString("topic_name"));
                        topic.setParentId(res.getInt("parent_id"));
                        topic.setType(res.getInt("type"));
                        topicList.add(topic);
                    } else if (currentCategoryId != res.getInt("topic_id")) {
                        topic.setCategoryId(res.getInt("topic_id"));
                        topic.setCategoryName(res.getString("topic_name"));
                        topic.setParentId(res.getInt("parent_id"));
                        topic.setType(res.getInt("type"));
                        topicList.add(topic);
                    }
                    currentCategoryId = topic.getCategoryId();
                }
                return topicList;
            } catch (SQLException sqle) {
                System.out.println(sqle);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return topicList;
    }

    /*
     * getCategorys() function is used to search topics based on parent id. * It
     * returns a list of topics based on a particular parent id * It takes two
     * arguments first is a list of topics to be searched and second a parent id
     * to search topics in all topics avaiable. *
     */
    
    
    /*
    public static ArrayList getCategorys(ArrayList categoryname, int parentid) {
        ArrayList resultSet = new ArrayList();
        Iterator iter = categoryname.iterator();
        while (iter.hasNext()) {
            Category question = (Category) iter.next();
            if (question.getParentid() == parentid) {
                resultSet.add(question);
            }
        }
        return resultSet;
    }

    /*
     * displayMenu function is used to generate dynamic tree menu based on
     * database. This is a recurrsive function to build a html list string. *
     * This function returns a string to generate a list (having html tags in
     * it).
     */
    
    /*
    public String displayMenu(ArrayList topics, HashMap<Integer, Integer> docCount, int parent_id, int level, boolean initial) {

        String html = "";
        ArrayList result = EContentMenuHelper.getCategorys(topics, parent_id);
        if (!initial) {
            html += "<ul>";
        }
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            Category topic = (Category) iter.next();
            try {
                if (topic.getType() == 1) {
                    int tempCount = getCategorysAppletCount(topic.getCategoryId(), docCount, topics, false);
                    if (tempCount > 0) {
                        html += "<li><a href='#'>" + topic.getCategoryName() + " " + " (" + tempCount + ")" + "</a>";
                        html += displayMenu(topics, docCount, topic.getCategoryId(), level + 1, false);
                    }
                } else if (topic.getType() == 0) {
                    int tempCount = getCategorysAppletCount(topic.getCategoryId(), docCount, topics, true);
                    if (tempCount > 0) {
                        html += "<li><a href='availableContents.do?topicId=" + topic.getCategoryId() + "'>" + topic.getCategoryName() + " " + " (" + tempCount + ")" + "</a></li>";
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (!initial) {
            html += "</ul>";
        }
        return html;
    }

    /*
     * displayMenu function is used to generate dynamic tree menu based on
     * database. This is a recurrsive function to build a html list string. *
     * This function returns a string to generate a list (having html tags in
     * it).
     */
    
    /*
    public String displayInteractiveMenu(ArrayList topics, HashMap<Integer, Integer> appletCount, int parent_id, int level, boolean initial) {

        String html = "";
        ArrayList result = EContentMenuHelper.getCategorys(topics, parent_id);
        if (!initial) {
            html += "<ul>";
        }
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            Category topic = (Category) iter.next();
            try {
                if (topic.getType() == 1) {
                    int appCount = getCategorysAppletCount(topic.getCategoryId(), appletCount, topics, false);
                    if (appCount > 0) {
                        html += "<li><a href='#'>" + topic.getCategoryName() + " " + " (" + appCount + ")" + "</a>";
                        html += displayInteractiveMenu(topics, appletCount, topic.getCategoryId(), level + 1, false);
                    }
                } else if (topic.getType() == 0) {
                    int appCount = getCategorysAppletCount(topic.getCategoryId(), appletCount, topics, true);
                    if (appCount > 0) {
                        html += "<li><a href='interactivelearning.do?topicId=" + topic.getCategoryId() + "'>" + topic.getCategoryName() + " " + " (" + appCount + ")" + "</a></li>";
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (!initial) {
            html += "</ul>";
        }
        return html;
    }
    
    
    
    public Category getCategory(int topicId, int langId) {
        Category topic = new Category();
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                pstmt = con.prepareStatement("select topics.topic_id,contents.topic_name,topics.parent_id,topics.type from topics inner join contents on (topics.topic_id = contents.topic_id) where contents.lang_id=? and topics.topic_id=?;");
                pstmt.setInt(1, langId);
                pstmt.setInt(2, topicId);
                res = pstmt.executeQuery();
                while (res.next()) {
                    topic.setCategoryId(res.getInt("topic_id"));
                    topic.setCategoryName(res.getString("topic_name"));
                    topic.setParentId(res.getInt("parent_id"));
                    topic.setType(res.getInt("type"));
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return topic;
    }

    public String getCategoryTree(ArrayList topics, int parent_id, int level) {
        String html = "";
        ArrayList result = EContentMenuHelper.getCategorys(topics, parent_id);
        html += "<ul>";
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            Category topic = (Category) iter.next();
            try {
                if (topic.getType() == 1) {
                    html += "<li><a href='#'>" + topic.getCategoryName() + "</a>";
                    html += getCategoryTree(topics, topic.getCategoryId(), level + 1);
                } else if (topic.getType() == 0) {
                    html += "<li><a href='showTranslationContents.do?topicId=" + topic.getCategoryId() + "'>" + topic.getCategoryName() + "</a></li>";
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        html += "</ul>";
        return html;
    }

    public String displayTranslatableCategory(int topicId, int langId) {
        String html = "<ul>";
        Category topic = getCategory(topicId, langId);
        ArrayList allCategorys = getAllCategorys(langId);
        if (topic.getType() == 1) {
            html += "<li><a href='#'>" + topic.getCategoryName() + "</a>";
            html += getCategoryTree(allCategorys, topic.getCategoryId(), 1);
        } else {
            html += "<li><a href='showTranslationContents.do?topicId=" + topic.getCategoryId() + "'>" + topic.getCategoryName() + "</a></li>";
        }
        html += "</ul>";
        return html;
    }

    /*
     * getCategoryList method is used for retreiving all topics available for
     * particular language ordered by topic name It takes a parameter language
     * id (langId). It returns a list of Categorys for particular language. If no
     * Category found, the function returns a empty list.
     */
    
    
    /*
    public ArrayList getCategoryList(int langId) {
        ArrayList topicList = new ArrayList();
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                pstmt = con.prepareStatement("select topics.topic_id,contents.topic_name,topics.parent_id,topics.type from topics inner join contents on (topics.topic_id = contents.topic_id) where contents.lang_id=? or contents.lang_id=1 order by contents.topic_name,contents.topic_id, contents.lang_id desc;");
                pstmt.setInt(1, langId);
                res = pstmt.executeQuery();
                int currentCategoryId = 0;
                while (res.next()) {
                    Category topic = new Category();
                    if (currentCategoryId == 0) {
                        topic.setCategoryId(res.getInt("topic_id"));
                        topic.setCategoryName(res.getString("topic_name"));
                        topic.setParentId(res.getInt("parent_id"));
                        topic.setType(res.getInt("type"));
                        topicList.add(topic);
                    } else if (currentCategoryId != res.getInt("topic_id")) {
                        topic.setCategoryId(res.getInt("topic_id"));
                        topic.setCategoryName(res.getString("topic_name"));
                        topic.setParentId(res.getInt("parent_id"));
                        topic.setType(res.getInt("type"));
                        topicList.add(topic);
                    }
                    currentCategoryId = topic.getCategoryId();
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return topicList;
    }

    
    
    
    /*
     * getCategoryList method is used for retreiving all topics available for
     * particular language ordered by topic name It takes a parameter language
     * id (langId). It returns a list of Categorys for particular language. If no
     * Category found, the function returns a empty list.
     */
    
    
    /*
    public ArrayList getCategoryListByLanguage(int langId) {
        ArrayList topicList = new ArrayList();
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                pstmt = con.prepareStatement("select topics.topic_id,contents.topic_name,topics.parent_id,topics.type from topics inner join contents on (topics.topic_id = contents.topic_id) where contents.lang_id=? order by contents.lang_id desc;");
                pstmt.setInt(1, langId);
                res = pstmt.executeQuery();
                int currentCategoryId = 0;
                while (res.next()) {
                    Category topic = new Category();
                    if (currentCategoryId == 0) {
                        topic.setCategoryId(res.getInt("topic_id"));
                        topic.setCategoryName(res.getString("topic_name"));
                        topic.setParentId(res.getInt("parent_id"));
                        topic.setType(res.getInt("type"));
                        topicList.add(topic);
                    } else if (currentCategoryId != res.getInt("topic_id")) {
                        topic.setCategoryId(res.getInt("topic_id"));
                        topic.setCategoryName(res.getString("topic_name"));
                        topic.setParentId(res.getInt("parent_id"));
                        topic.setType(res.getInt("type"));
                        topicList.add(topic);
                    }
                    currentCategoryId = topic.getCategoryId();
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return topicList;
    }

    /*
     * getCategoryList method is used for retreiving all topics which are child,
     * available for particular language ordered by topic name It takes a
     * parameter language id (langId). It returns a list of Categorys for
     * particular language. If no Category found, the function returns a empty
     * list.
     */
    
    
    /*
    public ArrayList getChildCategoryListByLanguage(int langId) {
        ArrayList topicList = new ArrayList();
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                pstmt = con.prepareStatement("select topics.topic_id,contents.topic_name,topics.parent_id,topics.type from topics inner join contents on (topics.topic_id = contents.topic_id) where topics.type=0 and contents.lang_id=? order by contents.lang_id desc;");
                pstmt.setInt(1, langId);
                res = pstmt.executeQuery();
                int currentCategoryId = 0;
                while (res.next()) {
                    Category topic = new Category();
                    if (currentCategoryId == 0) {
                        topic.setCategoryId(res.getInt("topic_id"));
                        topic.setCategoryName(res.getString("topic_name"));
                        topic.setParentId(res.getInt("parent_id"));
                        topic.setType(res.getInt("type"));
                        topicList.add(topic);
                    } else if (currentCategoryId != res.getInt("topic_id")) {
                        topic.setCategoryId(res.getInt("topic_id"));
                        topic.setCategoryName(res.getString("topic_name"));
                        topic.setParentId(res.getInt("parent_id"));
                        topic.setType(res.getInt("type"));
                        topicList.add(topic);
                    }
                    currentCategoryId = topic.getCategoryId();
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return topicList;
    }

    public boolean isChild(int parent, int child) {
        boolean result = false;
        ArrayList list = getAllCategorys(1);
        String isChild = findChild(list, parent, child);
        result = isChild.matches("true");
        return result;
    }

    public String findChild(ArrayList topics, int parent_id, int child_id) {
        String isChild = "";
        ArrayList result = EContentMenuHelper.getCategorys(topics, parent_id);
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            Category topic = (Category) iter.next();
            try {
                if (topic.getType() == 1) {
                    isChild += findChild(topics, topic.getCategoryId(), child_id);
                }
                if (topic.getCategoryId() == child_id) {
                    isChild += "true";
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return isChild;
    }

    public String getCategoryName(int topicId, int langId) {
        String topic = "";
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                pstmt = con.prepareStatement("select topics.topic_id,contents.topic_name,topics.parent_id,topics.type from topics inner join contents on (topics.topic_id = contents.topic_id) where (contents.lang_id=? or contents.lang_id=1) and topics.topic_id=? order by contents.lang_id desc");
                pstmt.setInt(1, langId);
                pstmt.setInt(2, topicId);
                res = pstmt.executeQuery();
                if (res.next()) {
                    topic = res.getString("topic_name");
                }
            } catch (SQLException sqle) {
                System.out.println(sqle);
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return topic;
    }

    /**
     *
     * @return
     */
    
    
    
    /*
    public HashMap<Integer, Integer> getAppletCount() {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        /*
         * Set up a new database if not already set
         */
    
    
    /*
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                /*
                 * Get all the distinct topic id
                 */
    
    /*
                pstmt = con.prepareStatement("SELECT DISTINCT(topic_id) FROM topics ORDER BY topic_id ASC");
                res = pstmt.executeQuery();
                /*
                 * get applet count for the particular applet
                 */
    
    /*
                pstmt1 = con.prepareStatement("SELECT count(ilo.applet_id) AS total FROM ilobjects ilo WHERE ilo.topic_id=? AND ilo.verified=true;");
                while (res.next()) {
                    pstmt1.setInt(1, res.getInt("topic_id"));
                    res1 = pstmt1.executeQuery();
                    if (res1.next()) {
                        countMap.put(res.getInt("topic_id"), res1.getInt("total"));
                    }
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closePStatement(pstmt1);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeResultSet(res1);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return countMap;
    }

    /**
     *
     * @return
     */
    
    /*
    public HashMap<Integer, Integer> getAppletCount(int type) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        /*
         * Set up a new database if not already set
         */
    
    /*
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                /*
                 * Get all the distinct topic id
                 */
    /*
                pstmt = con.prepareStatement("SELECT DISTINCT(topic_id) FROM topics ORDER BY topic_id ASC");
                res = pstmt.executeQuery();
                /*
                 * get applet count for the particular applet
                 */
    /*
                pstmt1 = con.prepareStatement("SELECT count(ilo.applet_id) AS total FROM ilobjects ilo WHERE ilo.topic_id=? AND ilo.verified=true AND object_type=?");
                while (res.next()) {
                    pstmt1.setInt(1, res.getInt("topic_id"));
                    pstmt1.setInt(2, type);
                    res1 = pstmt1.executeQuery();
                    if (res1.next()) {
                        countMap.put(res.getInt("topic_id"), res1.getInt("total"));
                    }
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closePStatement(pstmt1);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeResultSet(res1);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return countMap;
    }

    /**
     *
     * @param topicId
     * @param countMap
     * @param topics
     * @param initial
     * @return
     */
    
    
    /*
    public int getCategorysAppletCount(int topicId, HashMap<Integer, Integer> countMap, ArrayList topics, boolean initial) {
        int count = 0;
        if (initial) {
            if (countMap.containsKey(topicId)) {
                count += countMap.get(topicId);
            }
        }
        if (topics != null && countMap != null) {
            ArrayList dummy = EContentMenuHelper.getCategorys(topics, topicId);
            Iterator iter = dummy.iterator();
            while (iter.hasNext()) {
                Category topic = (Category) iter.next();
                try {
                    if (topic.getType() == 1) {
                        if (countMap.containsKey(topic.getCategoryId())) {
                            count += countMap.get(topic.getCategoryId());
                        }
                        count += getCategorysAppletCount(topic.getCategoryId(), countMap, topics, false);
                    } else if (topic.getType() == 0) {
                        if (countMap.containsKey(topic.getCategoryId())) {
                            count += countMap.get(topic.getCategoryId());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return count;
    }

    /**
     *
     * @return
     */
    
    /*
    public HashMap<Integer, Integer> getDocumentCount() {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        /*
         * Set up a new database if not already set
         */
    
    /*
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                /*
                 * Get all the distinct topic id
                 */
    
    
    /*
                pstmt = con.prepareStatement("SELECT DISTINCT(topic_id) FROM topics ORDER BY topic_id ASC");
                res = pstmt.executeQuery();
                /*
                 * get applet count for the particular applet
                 */
    
    
    
    /*
                pstmt1 = con.prepareStatement("SELECT count(document_id) AS total FROM documents WHERE verified=true AND topic_id=?");
                while (res.next()) {
                    pstmt1.setInt(1, res.getInt("topic_id"));
                    res1 = pstmt1.executeQuery();
                    if (res1.next()) {
                        countMap.put(res.getInt("topic_id"), res1.getInt("total"));
                    }
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closePStatement(pstmt1);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeResultSet(res1);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return countMap;
    }

    /**
     *
     * @param topicId
     * @param countMap
     * @param topics
     * @param initial
     * @return
     */
    
    
    /*
    public int getCategorysDocumentCount(int topicId, HashMap<Integer, Integer> countMap, ArrayList topics, boolean initial) {
        int count = 0;
        if (initial) {
            if (countMap.containsKey(topicId)) {
                count += countMap.get(topicId);
            }
        }
        if (topics != null && countMap != null) {
            ArrayList dummy = EContentMenuHelper.getCategorys(topics, topicId);
            Iterator iter = dummy.iterator();
            while (iter.hasNext()) {
                Category topic = (Category) iter.next();
                try {
                    if (topic.getType() == 1) {
                        if (countMap.containsKey(topic.getCategoryId())) {
                            count += countMap.get(topic.getCategoryId());
                        }
                        count += getCategorysAppletCount(topic.getCategoryId(), countMap, topics, false);
                    } else if (topic.getType() == 0) {
                        if (countMap.containsKey(topic.getCategoryId())) {
                            count += countMap.get(topic.getCategoryId());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        return count;
    }

    public ArrayList findCategoryTree(ArrayList topics, int parent_id, int level) {
        //String html = "";
        ArrayList result = EContentMenuHelper.getCategorys(topics, parent_id);
        //html += "";
        ArrayList topicList = new ArrayList();
        Iterator iter = result.iterator();
        if (level == 0) {
            if (topics != null) {
                for (int i = 0; i < topics.size(); i++) {
                    Category temp = (Category) topics.get(i);
                    if (temp.getCategoryId() == parent_id) {
                        topicList.add(temp);
                    }
                }
            }
        } else {
            Category tempCategory = getCategory(parent_id, 1);
            if (tempCategory != null && tempCategory.getType() == 0) {
                topicList.add(tempCategory);
            }
        }
        while (iter.hasNext()) {
            Category topic = (Category) iter.next();
            try {
                if (topic.getType() == 1) {
                    //html += findCategoryTree(topics, topic.getCategoryId(), level + 1);
                    topicList.addAll(findCategoryTree(topics, topic.getCategoryId(), level + 1));
                } else if (topic.getType() == 0) {
                    topicList.add(topic);
                    //html += ","+topic.getCategoryId();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        //html += "";
        return topicList;
    }

    /**
     *
     * @return
     */
    
    
    /*
    public HashMap<Integer, Integer> getCategoryCount() {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        /*
         * Set up a new database if not already set
         */
    
    
    
    /*
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                /*
                 * Get all the distinct topic id
                 */
    
    
    
    /*
                pstmt = con.prepareStatement("SELECT DISTINCT(topic_id) FROM topics ORDER BY topic_id ASC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                res = pstmt.executeQuery();
                /*
                 * get applet count for the particular applet
                 */
    
    
    /*
                pstmt1 = con.prepareStatement("SELECT count(document_id) AS total FROM documents WHERE verified=true AND topic_id=?");
                while (res.next()) {
                    pstmt1.setInt(1, res.getInt("topic_id"));
                    res1 = pstmt1.executeQuery();
                    if (res1.next()) {
                        int total = res1.getInt("total");
                        if (total > 0) {
                            countMap.put(res.getInt("topic_id"), total);

                        }
                    }
                }
                res.beforeFirst();
                pstmt1 = con.prepareStatement("SELECT count(ilo.applet_id) AS total FROM ilobjects ilo WHERE ilo.topic_id=? AND ilo.verified=true;");
                while (res.next()) {
                    pstmt1.setInt(1, res.getInt("topic_id"));
                    res1 = pstmt1.executeQuery();
                    if (res1.next()) {
                        int total = res1.getInt("total");
                        if (total > 0) {
                            countMap.put(res.getInt("topic_id"), res1.getInt("total"));
                        }
                    }
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closePStatement(pstmt1);
                EkShikshaDBConnection.closeResultSet(res);
                EkShikshaDBConnection.closeResultSet(res1);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        return countMap;
    }

    public String getAvailableCategoryTree() {
        String html = "";
        ArrayList topics = new ArrayList();
        HashMap<Integer, Integer> topicsCount = new HashMap<Integer, Integer>();
        int parent_id = 0;
        int level = 1;
        boolean initial = true;
        topics = getAllCategorys(1);
        try {
            topicsCount = getCategoryCount();

        } catch (Exception e) {
            e.printStackTrace();
        }
        html = generateAvailableCategoryTree(topics, topicsCount, parent_id, level, initial);
        return html;
    }

    public String generateAvailableCategoryTree(ArrayList topics, HashMap<Integer, Integer> docCount, int parent_id, int level, boolean initial) {
        String html = "";
        ArrayList result = EContentMenuHelper.getCategorys(topics, parent_id);
        if (!initial) {
            html += "<ul>";
        }
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            Category topic = (Category) iter.next();
            try {
                if (topic.getType() == 1) {
                    int tempCount = getCategorysAppletCount(topic.getCategoryId(), docCount, topics, false);
                    if (tempCount > 0) {
                        if (level == 1) {
                            html += "<li id=\"" + topic.getCategoryId() + "\" class=\"root\"><input name=\"" + topic.getCategoryId() + "\" class=\"topic\" type=\"checkbox\"/>" + topic.getCategoryName() + "<span class=\"expand\">&nbsp;</span>";
                        } else {
                            html += "<li id=\"" + topic.getCategoryId() + "\" class=\"child\"><input name=\"" + topic.getCategoryId() + "\" class=\"topic\" type=\"checkbox\"/>" + topic.getCategoryName() + "<span class=\"expand\">&nbsp;</span>";
                        }

                        html += generateAvailableCategoryTree(topics, docCount, topic.getCategoryId(), level + 1, false);
                    }
                } else if (topic.getType() == 0) {
                    int tempCount = getCategorysAppletCount(topic.getCategoryId(), docCount, topics, true);
                    if (tempCount > 0) {
                        html += "<li id=\"" + topic.getCategoryId() + "\" class=\"leaf\"><input name=\"" + topic.getCategoryId() + "\" class=\"topic\" type=\"checkbox\"/>" + topic.getCategoryName() + "</li>";
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (!initial) {
            html += "</ul>";
        }
        return html;
    }

    /**
     * this function finds the hierarchy of topics
     *
     * @param topicId
     * @param landId
     * @return a string comprising of the parent topics from the root
     */
    
    
    
    
    /*
    public String getAncestorsId(int topicId, int landId) {
        /*
         * Setting the parent to empty string
         */
    
    
    
    /*
        String parent = "";
        int currentId = topicId;
        int count = 0;
        if (EkShikshaDBConnection.isClosed(con)) {
            con = EkShikshaDBConnection.getDBConnection();
        }
        if (!EkShikshaDBConnection.isClosed(con)) {
            try {
                parent+=topicId+"-";
                while (currentId != 0) {
                    /*
                     * Get the name and topic id of the parent
                     */
    
    
    /*
                    String statement = "SELECT  topic_id,topic_name FROM contents WHERE topic_id=(SELECT parent_id FROM topics where topic_id=?  ) AND  (lang_id=? OR lang_id=1) ORDER BY lang_id DESC";
                    pstmt = con.prepareStatement(statement);
                    pstmt.setInt(1, currentId);
                    pstmt.setInt(2, landId);
                    res1 = pstmt.executeQuery();
                    /*
                     * if parent exists
                     */
    
    /*
                    if (res1.next()) {
                        currentId = res1.getInt("topic_id");
                        //System.out.print("\n currentId= : "+ currentId);
                        parent += res1.getString("topic_id") + "-";
                        //System.out.print("  parent = : "+ parent);
                        count++;
                    } else {
                        break;
                    }
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            } finally {
                EkShikshaDBConnection.closePStatement(pstmt);
                EkShikshaDBConnection.closeResultSet(res1);
                EkShikshaDBConnection.closeDBConnection(con);
            }
        }
        /*
         * process the parent string
         */
    
    /*
        String temparr[] = parent.split("-");
        parent = "";
        for (int ind = temparr.length - 1; ind >= 0; ind--) {
            parent += temparr[ind];
            if (ind != 0) {
                parent += "-";
            }
        }
        return parent;
    }
    
    
    
    
    /*
     * displayMenu function is used to generate dynamic tree menu based on
     * database. This is a recurrsive function to build a html list string. *
     * This function returns a string to generate a list (having html tags in
     * it).
     */
    public String createCategoryMenu(ArrayList categoryname, int parentid, int level, boolean initial) {

        String html = "";
        ArrayList result = EContentMenuHelper.getCategory(parentid, parentid);
        if (!initial) {
            html += "<ul>";
        }
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            Category topic = (Category) iter.next();
            try {
                if (topic.getType() == 1) {
                    html += "<li data-expanded=\"true\">" + topic.getCategoryName();
                    html += createCategoryMenu(categoryname, topic.getCategoryId(), level + 1, false);
                    
                } else if (topic.getType() == 0) {
                    html += "<li class=\"Node\">" + topic.getCategoryName()+ "</li>";
                    
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        if (!initial) {
            html += "</ul>";
        }
        return html;
    }

    public static void main(String[] args) {
        EContentMenuHelper menuHelper = new EContentMenuHelper();
        ArrayList<Category> topics = menuHelper.getAllCategory(1);
        String topicMenu = menuHelper.createCategoryMenu(topics, 0, 0, true);
    }

    private ArrayList<Category> getAllCategory(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
