#include<iostream>
#include<string>
#include<vector>
#include<iomanip>
#include<cstdlib>
#include<ctime>
#include<conio.h>
#include<string.h>
#include<fstream>
using namespace std;

int user_id_num = 0, course_id_num = 0;
int ID_in = 0;

class Teacher;

class Course{
public:
	string topic;
	int course_id; 
	string course_name;
	int course_credit;
	vector<int> student_id;
	vector<int> teacher_id;
	Course(int ri, string t, int xf):student_id(ri),course_name(t),course_credit(xf){ course_id = course_id_num; }
	virtual ~Course(){}
	friend ostream& operator <<(ostream&, Course&);
	friend istream& operator >>(istream&, Course&);
	int search_t(string str){ if (topic.find(str) != string::npos)return 1;  return 0; }
	void print_student_number_list(); 
	//virtual int GPA() = 0;
};

ostream& operator <<(ostream& output, Course& course)
{
	output << "课程名称:" << course.course_name << endl << "课程学分:" << course.course_credit << endl;
	output << "课程编号:" << course.course_id << endl;
	return output;
}

istream& operator >>(istream& input, Course& course)
{
	string str_in;
	course_id_num++;
	input.ignore(20, ':');
	input >> course.course_name;
	input.ignore(20, ':');
	input >> course.course_credit;
	input.ignore(20, ':');
	input >> course.course_id;
	input.ignore(20, ':');
	input >> str_in;
	return input;
}

void Course::print_student_number_list()
{
	if (student_id.empty())
	{
		cout << "学生列表空。" << endl;
		return;
     }
	for (vector<int>::iterator i = student_id.begin(); i < student_id.end(); i++)
	cout << (*i) << endl;
}

class ComCourse :public Course{
public:
    vector<ComCourse> comcourse;
	ComCourse(int ri = 0, string t = "\0", int xf) :Course(ri, t,xf){};
	//int GPA(){ return (int)(course_stu_number*stuent_result*course_credit/all_result); }
	ComCourse& operator =(ComCourse& comcourse){
		course_credit=comcourse.course_credit;
		student_id=comcourse.student_id;
		teacher_id = comcourse.teacher_id;
		course_id = comcourse.course_id;
	}
};

class EleCourse :public Course{
public:
	vector<EleCourse> elecourse;
	EleCourse(int ri = 0, string c = 0, int xf) :Course(ri, c,xf){};
	//int GPA(){ return (int)(sprt(student_result)/10*course_credit); }
	friend ostream& operator <<(ostream&, EleCourse&);
	friend istream& operator >>(istream&, EleCourse&);
	EleCourse& operator =(EleCourse& elecourse){
		course_credit = elecourse.course_credit;
		student_id = elecourse.student_id;
		teacher_id = elecourse.teacher_id;
		course_id = elecourse.course_id;
	}
};

ostream& operator <<(ostream& output, EleCourse& elecourse)
{
	output << (*(Course*)&elecourse);
	if (ID_in == 0)
		//output << "选修课编号:" << setfill('0') << setw(4) << elecourse.pri_id << endl;
	return output;
}


istream& operator >>(istream& input, EleCourse& elecourse)
{
	input >> (*(Course*)&elecourse);
	input.ignore(20, ':');
	//input >> elecourse.pri_id;
	return input;
}

class User{
public:
    string name;
	int user_id;
	string colleage;
    vector<int> course_id;
	User(string n, string p) :name(n),colleage(p){ user_id = user_id_num++;}
	void reconstractor(string n = "\0", string p = "\0"){ user_id = ++user_id_num; colleage = p; name = n;}
	void print_course_list();
	virtual ~User(){}
	virtual void print_user() = 0;
};

void User::print_course_list()
{
	if (course_id.empty())
	{
		cout << "选课列表空。" << endl;
		return;
     }
	for (vector<int>::iterator i = course_id.begin(); i < course_id.end(); i++)
		cout << (*i) << endl;
}

class CourseStudent :public User{
public:
    int id;
	vector<CourseStudent> student;
    int GPA;
    int class_id;
    vector<int> student_results;
	CourseStudent(string n = "\0", string p = "\0") :User(n, p){GPA = 0; class_id = 0;}
	void print_user();
	void reconstractor(int i, string n = "\0", string p = "\0"){colleage = p; name = n;class_id=i;}
	void add_course(int);
	void minus_course(int);
};

void CourseStudent::print_user()
{
	cout << "ID=" << setfill('0') << setw(4) << user_id << endl << "名字=" << name << endl << endl;
	cout << "学院=" << setfill('0') << setw(4) << colleage << endl << "班级=" << class_id << endl << endl;
}

void CourseStudent::add_course(int course_ic)
{
	int option;
	cout << "请确认选择此门选修课" << endl;
	cout << "1,是" << endl << "2,否" <<endl;
	if (option == 1)
	{
		course_id.push_back(course_ic);
	} 
} 

void CourseStudent::minus_course(int course_ci)
{
	int option;
	cout << "请确认删除此门选修课" << endl;
	cout << "1,是" << endl << "2,否" <<endl;
	if (option == 1)
	{
		for (vector<int>::iterator i = course_id.begin(); i < course_id.end(); i++)
		if ( (*i)==course_ci )
			course_id.erase(i);
	} 
}

class CourseTeacher :public User{
public:
    int id;
    vector<CourseTeacher> teacher;
	CourseTeacher(string n = "\0", string p = "\0") :User(n, p){}
	void print_user();
	void Scoreregistration(vector<CourseStudent> student_list, int course_icc,int student_id, int student_result);
};

void CourseTeacher::print_user()
{
	cout << "ID=" << setfill('0') << setw(4) << user_id << endl << "名字=" << name << endl << endl;
	cout << "学院=" << setfill('0') << setw(4) << colleage << endl ;
	print_course_list(); 
}

void CourseTeacher::Scoreregistration(vector<CourseStudent> student_list, int course_icc,int student_id, int student_result)
{
	int k=0;
	for (vector<CourseStudent>::iterator i = student_list.begin(); i < student_list.end(); i++)
	if ((*i).user_id==	student_id)
	{
		for (vector<int>::iterator j = (*i).course_id.begin(); j < (*i).course_id.end(); j++,k++)
		if((*j)==course_icc) {
			vector<int>::iterator l=((*i).student_results).begin();
			l+=k;
			(*l)=student_result;
		}
		
	}
}

Course* search_course(vector<ComCourse> comcourse,vector<EleCourse> elecourse, int id = 0,string str = "\0")
{
	int j = 0;
	for (vector<ComCourse>::iterator i = comcourse.begin(); i < comcourse.end(); i++)
	{
		if (id != 0 && (*i).course_id == id)
			return &(*i);
		else if ((str != "\0" && (*i).search_t(str)) && (j = 1))
			cout << (*i) << endl;
	}
	for (vector<EleCourse>::iterator i = (*i).elecourse.begin(); i < (*i).elecourse.end(); i++)
	{
		if (id != 0 && (*i).course_id == id)
			return &(*i);
		else if ((str != "\0" && (*i).search_t(str)) && (j = 1))
			cout << (*i) << endl;
	}
	if (id == 0 && j == 0)
		cout << "没有结果。" << endl;
}

User* search_user(vector<CourseStudent>& student, vector<CourseTeacher>& teacher, int ID)
{
	for (vector<CourseStudent>::iterator it = student.begin(); it < student.end(); it++)
		if ((*it).id == ID)
			return &(*it);
	for (vector<CourseTeacher>::iterator it = teacher.begin(); it < teacher.end(); it++)
		if ((*it).id == ID)
			return &(*it);
	return NULL;
}
int main()
{
	int option, is_teacher, int_in, id_in, student_result,course_icc,student_id;
	string str_in;
	CourseStudent *name1;
	CourseTeacher *name2;

	vector<CourseTeacher> teacher;
	vector<CourseStudent> student;
	vector<CourseStudent> student_list;
	
	vector<Course> course;
	
	Course *course1;
	
	vector<ComCourse> comcourse;
	vector<EleCourse> elecourse;

	CourseTeacher pd;
	CourseStudent pu;

	pd.reconstractor("A教师"); teacher.push_back(pd);
	pd.reconstractor("B教师"); teacher.push_back(pd);

	pu.reconstractor(1,"A学生","计算机"); student.push_back(pu);
	pu.reconstractor(2,"B学生","计算机"); student.push_back(pu);
	pu.reconstractor(3,"C学生","计算机"); student.push_back(pu);
	pu.reconstractor(4,"D学生","计算机"); student.push_back(pu);

screen:
	str_in.clear();
	int_in = 0;
	is_teacher = 0;
	system("cls");
	cout << "                            欢迎使用学生成绩管理系统" << endl;
	cout << "1,学生入口" << endl << "2,教师入口" << endl << "3,退出程序" << endl << "请选择：";
	cin >> option;
	if (cin.rdstate() != cin.goodbit || option < 1 || option > 3)
	{
		cout << "输入有误，请重新输入。" << endl;
		cin.clear();
		cin.sync();
		system("pause");
		goto screen;
	}
	if (option == 3)
	{
		return 0;
	}
	system("cls");
	cout << "请输入您的学号或工号：";
	cin >> ID_in;
	if (cin.rdstate() != cin.goodbit || ID_in < 1 || ID_in>10)
	{
		cout << "输入错误" << endl;
		cin.clear();
		cin.sync();
		system("pause");
		goto screen;
	}
		else
			cout << "*";
	for (int i = 0; int_in != -1 && i < (int)str_in.size(); i++)
	{
		if (str_in[i]>'9' || str_in[i] < '0')
			int_in = -1;
		else
		{
			int_in *= 10;
			int_in += str_in[i] - '0';
		}
	}
	if (int_in < 0 || int_in>10)
	{
		cout << endl << "账号密码错误或不匹配，请重新输入。" << endl;
		system("pause");
		goto screen;
	}
	else
	{
		cout << endl << "登录成功！" << endl;
		is_teacher = option - 1;
		if(is_teacher = 0)
		name1=(CourseStudent*)search_user(student, teacher, ID_in);
		else
		name2=(CourseTeacher*)search_user(student, teacher, ID_in);
		system("pause");
		goto user_screen;
	}

user_screen:
	system("cls");
	cout << "1,获取已选课程列表" << endl << "2,获取个人信息" << endl << "3,搜索课程" << endl;
	if (is_teacher == 0) 
		cout << "4,获取可选选修课列表" << endl << "5,提交选课与放弃选课" << endl << "6,查看个人课程成绩与绩点" << endl << "7,注销登录" << endl << "请选择：";
	else
		cout << "4,查看选课学生名单及个人信息" << endl << "5,成绩录入与修改" << endl << "6,注销登录" << endl << "请选择：";
	cin >> option;
	if (cin.rdstate() != cin.goodbit || is_teacher == 0 && (option < 1 || option > 7) || is_teacher == 1 && (option < 1 || option > 6))
	{
		cout << "输入有误，请重新输入。" << endl;
		cin.clear();
		cin.sync();
		system("pause");
		goto user_screen;
	}
	if (is_teacher == 0 && option == 7 || option == 6)
	{
		is_teacher = 0;
		ID_in = 0;
		goto screen;
	}
	else if (option == 1)
	{
		system("cls");
		if(is_teacher = 0)
		name1->print_course_list();
		else
		name2->print_course_list();
		system("pause");
		goto user_screen;
	}
	else if (option == 2)
	{
		system("cls");
		if(is_teacher = 0)
		{
			name1=(CourseStudent*)search_user(student, teacher, ID_in);
			(*name1).print_user();
		}
		else
		{
			name2=(CourseTeacher*)search_user(student, teacher, ID_in);
			(*name2).print_user();
		}
		system("pause");
		goto user_screen;
	}
	else if (option == 3)
	{
		system("cls");
		cout << "1,根据课程编号" << endl << "2,根据课程名称" << endl << "请选择：";
		cin >> option;
		if (cin.rdstate() != cin.goodbit || option < 1 || option > 2)
		{
			cout << "输入有误，请重新输入。" << endl;
			cin.clear();
			cin.sync();
			system("pause");
			goto user_screen;
		}
		if (option == 1)
		{
			cout << "请输入课程编号：";
			cin >> id_in;
			course1=search_course(comcourse, elecourse, id_in);
			cout << *course1 << endl;
		}
		else
		{
			cout << "请输入课程名称关键词，例如：物理 云计算 生物科学。";
			cin >> str_in;
			search_course(comcourse, elecourse, 0,str_in);
		}
		system("pause");
		goto user_screen;
	}
	else if (option == 4)
	{
	    system("cls");
		if (is_teacher == 0)
	    {
		    if(is_teacher = 0)
			name1->print_course_list();
			else
			name2->print_course_list();
		    system("pause");
		    goto user_screen;
    	}
    	else
    	{
        	if(is_teacher = 0)
			name1->print_course_list();
			else
			name2->print_course_list();
		    cout << "1,根据课程编号" << endl << "2,根据课程名称" << endl << "请选择：";
	     	cin >> option;
			if (cin.rdstate() != cin.goodbit || option < 1 || option > 2)
			{
				cout << "输入有误，请重新输入。" << endl;
				cin.clear();
				cin.sync();
				system("pause");
				goto user_screen;
			}
			if (option == 1)
			{
				cout << "请输入课程编号：";
				cin >> id_in;
				search_course(comcourse,elecourse, id_in);
			}
			else
			{
				cout << "请输入课程名称关键词，例如：物理 云计算 生物科学。";
				cin >> str_in;
				search_course(comcourse,elecourse, 0 ,str_in);
			}
			course1->print_student_number_list();
			if(is_teacher = 0)
		{
			name1=(CourseStudent*)search_user(student, teacher, ID_in);
			(*name1).print_user();
		}
		else
		{
			name2=(CourseTeacher*)search_user(student, teacher, ID_in);
			(*name2).print_user();
		}
			system("pause");
			goto user_screen;
	    }
	}
	else if (option == 5)
	{
		system("cls");
		if (is_teacher == 0)
		{
		    cout << "请输入你选择的课程编号：";
	        cin >> int_in;
		    if (cin.rdstate() != cin.goodbit || int_in < 1 || int_in > 9999)
		    {
			    cout << "输入有误，请重新输入。" << endl;
			    cin.clear();
			    cin.sync();
			    system("pause");
			    goto user_screen;
		    }
            else if (int_in > course_id_num)
		    {
			    cout << "没有找到该课程。" << endl;
			    system("pause");
			    goto user_screen;
		    }
		    else 
			{
				cout << "1,选择" << endl << "2,删除" << endl;
				cin >> option;
				if (cin.rdstate() != cin.goodbit || int_in < 1 || int_in > 2)
		    	{
			    	cout << "输入有误，请重新输入。" << endl;
			    	cin.clear();
			    	cin.sync();
			    	system("pause");
			    	goto user_screen;
		    	}
	    	    if (option == 1)
	    	    {
		     	   	name1->add_course(int_in);
    	    		if(is_teacher = 0)
					name1->print_course_list();
					else
					name2->print_course_list();
		        	system("pause"); 
		        	goto user_screen;
    	    	}
		        else
		        {
        			name1->minus_course(int_in);
        			if(is_teacher = 0)
					name1->print_course_list();
					else
					name2->print_course_list();
		        	system("pause"); 
		        	goto user_screen;
        		}        
			}
		}
         else
         {
      	    system("cls");
   	    	name2->print_course_list();
      	    cout << "1，请输入课程编号：" << endl << "2,请输入课程名称" << endl << "请选择：";
      	    cin >> option;
	        if (cin.rdstate() != cin.goodbit || option < 1 || option > 2)
			{
				cout << "输入有误，请重新输入。" << endl;
				cin.clear();
				cin.sync();
				system("pause");
				goto user_screen;
			}
			if (option == 1)
			{
				cout << "请输入课程编号：";
				cin >> id_in;
				search_course(comcourse,elecourse, id_in);
			}
			else
			{
				cout << "请输入课程名称关键词，例如：物理 云计算 生物科学。" << endl;
				cin >> str_in;
				search_course(comcourse,elecourse, id_in);
			}
		    	cout << "开始录入" << endl;
				Scoreregistration(student_list,course_icc,student_id,student_result);
	}
	else
	{
		print_student_result(student_result,course_stu_number,course_credit,all_result);
		system("pause");
		goto user_screen;
	} 
}
}