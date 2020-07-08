-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 27, 2019 at 04:54 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `alpha_school_mgt_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phoneNo` varchar(20) DEFAULT NULL,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `first_name`, `last_name`, `email`, `username`, `password`, `phoneNo`, `date_reg`) VALUES
(105, 'samuel', 'unachukwu', 'una@gmail.com', 'sam11', 'sam11', '1234', '2018-12-14 09:59:36'),
(121, 'admin', 'admin', 'admin@alpha.com', 'admin', '123', '08145226456', '2019-02-11 13:50:29');

-- --------------------------------------------------------

--
-- Table structure for table `course_reg`
--

CREATE TABLE `course_reg` (
  `course_reg_id` int(12) NOT NULL,
  `course_code` varchar(20) DEFAULT NULL,
  `course_title` varchar(20) DEFAULT NULL,
  `course_unit` varchar(12) DEFAULT NULL,
  `semester` varchar(12) DEFAULT NULL,
  `reg_id` int(11) DEFAULT NULL,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dept_registration`
--

CREATE TABLE `dept_registration` (
  `dept_id` int(11) NOT NULL,
  `faculty` varchar(200) DEFAULT NULL,
  `department` varchar(100) DEFAULT NULL,
  `no_of_lecturers` int(20) DEFAULT NULL,
  `hod_name` varchar(200) DEFAULT NULL,
  `date_reg` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dept_registration`
--

INSERT INTO `dept_registration` (`dept_id`, `faculty`, `department`, `no_of_lecturers`, `hod_name`, `date_reg`) VALUES
(9, 'SCIENCE', 'COMPUTER SCIENCE', 5, 'MR OKI', '2019-02-11 13:54:23'),
(10, 'SCIENCE', 'MATHEMATICS', 5, 'MR JAMES', '2019-02-11 13:54:45'),
(11, 'HEALTH SCIENCE', 'MEDICAL LABORATORY', 9, 'MRS OWOLABI', '2019-02-11 13:55:19'),
(12, 'EDUCATION', 'LIBRARY SCIENCE', 17, 'MRS OKEY', '2019-02-11 13:55:57'),
(13, 'ENGINEERING', 'ELECTRICAL ENGINEERING', 5, 'MR JACKSON', '2019-02-11 13:56:30'),
(14, 'ENGINEERING', 'AGRIC  ENGINEERING', 7, 'MR JONAH', '2019-02-11 13:56:56'),
(15, 'BUSINESS ADMIN', 'MARKETING', 7, 'MR KOLA', '2019-02-11 13:57:43'),
(16, 'BUSINESS ADMIN', 'BANNKING AND FINANCE', 4, 'MR EDET', '2019-02-11 13:58:27');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `id` int(10) NOT NULL,
  `dept_id` int(10) DEFAULT NULL,
  `questions` text,
  `option1` text,
  `option2` text,
  `option3` text,
  `option4` text,
  `students_answer` text,
  `correct_answer` text,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`id`, `dept_id`, `questions`, `option1`, `option2`, `option3`, `option4`, `students_answer`, `correct_answer`, `date`) VALUES
(8, 10, 'what is a variable', 'its a space', 'a memory location ', 'a car ', 'a dance step', 'a memory location ', 'a memory location ', '2019-02-11 14:36:19'),
(9, 10, 'these are datatypes except?', 'float', 'bigbyte', 'long', 'boolean', 'long', 'bigbyte', '2019-02-11 14:37:07'),
(10, 10, 'these are input devices except?', 'keyboard', 'light pen', 'monitor', 'mouse', 'light pen', 'monitor', '2019-02-11 14:38:58'),
(11, 10, 'array index starts from ?', '2', '4', '1', '0', '0', '0', '2019-02-11 14:39:27');

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `message_id` int(12) NOT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `level` int(20) DEFAULT NULL,
  `matno` varchar(20) DEFAULT NULL,
  `student_email` varchar(50) DEFAULT NULL,
  `lecturer_email` varchar(50) NOT NULL,
  `subject` text,
  `message` text,
  `lecturer_response` text,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`message_id`, `dept_id`, `level`, `matno`, `student_email`, `lecturer_email`, `subject`, `message`, `lecturer_response`, `date`) VALUES
(1, 10, 100, '19/001', 'stu@alpha.com', 'okapara@alpha.com', 'adsentee', 'sorry, i couldnt make it to dotayds lecturer', 'your mad', '2019-02-26 13:04:44');

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

CREATE TABLE `lecturer` (
  `staff_id` int(12) NOT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `phoneno` int(255) DEFAULT NULL,
  `admin_id` varchar(12) DEFAULT NULL,
  `dept_id` int(12) NOT NULL,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`staff_id`, `firstname`, `lastname`, `email`, `username`, `password`, `phoneno`, `admin_id`, `dept_id`, `date_reg`) VALUES
(113, 'lecturer001', 'lecturer001', 'lec@alpha.com', 'lec1', '123', 715564623, '105', 10, '2019-02-11 13:59:42'),
(114, 'ogefi', 'okpara', 'okapara@alpha.com', 'okp1', 'okp1', 715544623, '105', 9, '2019-02-11 14:02:37'),
(115, 'edeh', 'linus', 'linus@alpha.com', 'linu', 'li123', 1878644623, '105', 14, '2019-02-11 14:06:42'),
(116, 'okoye', 'emeka', 'emeka@alpha.com', 'emy', 'emy201', 7044534, '105', 12, '2019-02-11 14:28:45');

-- --------------------------------------------------------

--
-- Table structure for table `lecture_notes`
--

CREATE TABLE `lecture_notes` (
  `id` int(11) NOT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `course_code` varchar(50) DEFAULT NULL,
  `note` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lecture_notes`
--

INSERT INTO `lecture_notes` (`id`, `dept_id`, `username`, `course_code`, `note`) VALUES
(7, 10, 'lec1', 'COM101', '	HOW TO VALIDATE SOFTWARE\n package com.appsdeveloperblog.encryption;\n \npublic class VerifyProvidedPassword {\n    public static void main(String[] args)\n    {\n        // User provided password to validate\n        String providedPassword = \"myPassword123\";\n                \n        // Encrypted and Base64 encoded password read from database\n        String securePassword = \"HhaNvzTsVYwS/x/zbYXlLOE3ETMXQgllqrDaJY9PD/U=\";\n        \n        // Salt value stored in database \n        String salt = \"EqdmPh53c9x33EygXpTpcoJvc4VXLK\";\n        \n        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);\n        \n        if(passwordMatch) \n        {\n            System.out.println(\"Provided user password \" + providedPassword + \" is correct.\");\n        } else {\n            System.out.println(\"Provided password is incorrect\");\n        }\n\n    }\n}\n'),
(8, 10, 'lec1', 'COM103', 'Topic: Arraylist:\n\nimport java.util.ArrayList;\n\npublic class ComparingList {\n   public static void main(String[] args) {\n      ArrayList<String> list1 = new ArrayList<String>();\n      list1.add(\"JavaFx\");\n      list1.add(\"Java\");\n      list1.add(\"WebGL\");\n      list1.add(\"OpenCV\");\n      ArrayList<String> list2 = new ArrayList<String>();\n      list2.add(\"JavaFx\");\n      list2.add(\"Java\");\n      list2.add(\"WebGL\");\n      list2.add(\"OpenCV\");\n      System.out.println(list2);\n      System.out.println(list1.equals(list2));\n   }\n}');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `reg_id` int(12) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `level` int(5) DEFAULT NULL,
  `dept_id` int(12) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `matric_no` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `admin_id` int(12) DEFAULT NULL,
  `date_reg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`reg_id`, `first_name`, `last_name`, `level`, `dept_id`, `email`, `matric_no`, `username`, `password`, `admin_id`, `date_reg`) VALUES
(110, 'student001', 'student001', 100, 10, 'stu@alpha.com', '19/001', 'stu1', '123', 105, '2019-02-11 14:01:16'),
(111, 'victor', 'johnson', 100, 9, 'vic@alpha.com', '19/002', 'vic', '123', 105, '2019-02-11 14:05:51'),
(112, 'bassey', 'usman', 200, 9, 'bassey@alpha.com', '19/003', 'bass', '123', 105, '2019-02-11 14:07:48'),
(113, 'chike', 'owo', 300, 13, 'chike@alpha.com', '19/004', 'chike', 'chik123', 105, '2019-02-11 14:21:59');

-- --------------------------------------------------------

--
-- Table structure for table `students_score`
--

CREATE TABLE `students_score` (
  `id` int(11) NOT NULL,
  `dept_id` int(50) DEFAULT NULL,
  `matric_no` varchar(50) DEFAULT NULL,
  `level` int(20) DEFAULT NULL,
  `semester` varchar(20) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students_score`
--

INSERT INTO `students_score` (`id`, `dept_id`, `matric_no`, `level`, `semester`, `score`, `date`) VALUES
(19, 10, '19/001', 100, '1st', 3.5, '2019-02-11 14:49:09'),
(20, 10, '19/001', 100, '2nd', 4, '2019-02-11 15:07:11'),
(21, 10, '19/001', 0, '', 20, '2019-02-25 13:19:57');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `user_name` (`username`);

--
-- Indexes for table `course_reg`
--
ALTER TABLE `course_reg`
  ADD PRIMARY KEY (`course_reg_id`);

--
-- Indexes for table `dept_registration`
--
ALTER TABLE `dept_registration`
  ADD PRIMARY KEY (`dept_id`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`message_id`),
  ADD UNIQUE KEY `matno` (`matno`);

--
-- Indexes for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`staff_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `lecture_notes`
--
ALTER TABLE `lecture_notes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`reg_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `matric_no` (`matric_no`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `students_score`
--
ALTER TABLE `students_score`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT for table `course_reg`
--
ALTER TABLE `course_reg`
  MODIFY `course_reg_id` int(12) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `dept_registration`
--
ALTER TABLE `dept_registration`
  MODIFY `dept_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `message_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `lecturer`
--
ALTER TABLE `lecturer`
  MODIFY `staff_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;

--
-- AUTO_INCREMENT for table `lecture_notes`
--
ALTER TABLE `lecture_notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `reg_id` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;

--
-- AUTO_INCREMENT for table `students_score`
--
ALTER TABLE `students_score`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
