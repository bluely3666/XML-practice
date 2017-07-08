package cn.chengzhang.Dao;

import cn.chengzhang.domain.Student;
import cn.chengzhang.utils.XmlUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * Created by chen on 07/07/2017.
 */
public class StudentDao {

    public void add(Student s) {
        try {
            Document document = XmlUtils.getDocument();
            //create the tag for student
            Element Student_tag = document.createElement("student");
            Student_tag.setAttribute("idcard",s.getIdcard());
            Student_tag.setAttribute("examid",s.getExamid());

            //create the tag for name,location,grade
            Element name = document.createElement("name");
            Element location = document.createElement("location");
            Element grade = document.createElement("grade");

            name.setTextContent(s.getName());
            location.setTextContent(s.getLocation());
            grade.setTextContent(s.getGrade()+"");

            Student_tag.appendChild(name);
            Student_tag.appendChild(location);
            Student_tag.appendChild(grade);

            document.getElementsByTagName("exam").item(0).appendChild(Student_tag);

            //renew jvm
            XmlUtils.write2Xml(document);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Student find(String examid){

        try {
            Document document = XmlUtils.getDocument();
            NodeList list = document.getElementsByTagName("Student");
            for(int i =0;i<list.getLength();i++){
                Element Student_tag = (Element) list.item(i);
                if(Student_tag.getAttribute("examid").equals(examid)){
                    Student s = new Student();
                    s.setExamid(examid);
                    s.setIdcard(Student_tag.getAttribute("idcard"));

                   s.setName( Student_tag.getElementsByTagName("name").item(0).getTextContent());
                   s.setLocation(Student_tag.getElementsByTagName("location").item(0).getTextContent());
                   s.setGrade(Double.parseDouble(Student_tag.getElementsByTagName("grade").item(0).getTextContent()));
                }

            }
            return null;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String name){
        try {
            Document document = XmlUtils.getDocument();
            NodeList list = document.getElement
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
