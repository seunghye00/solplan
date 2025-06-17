import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const SignupForm = () => {
  const [form, setForm] = useState({
    userId: '',
    pwd: '',
    confirmPwd: '',
    name: '',
    email: '',
    addr: '',
    phone: '',
    ssn: '',
  });

  const navigate = useNavigate();

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = e.target;
    setForm(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    
    // 백엔드에 보낼 DTO에서 confirmPwd는 제외
    const { confirmPwd, ...signupData } = form;

    try {
      const res = await axios.post('http://localhost:8081/api/users/signup', signupData);
      alert('회원가입 성공!');
      navigate('/');
    } catch (err: any) {
      alert('회원가입 실패: ' + (err.response?.data?.message || '오류 발생'));
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="userId" placeholder="아이디" value={form.userId} onChange={handleChange} required />
      <input name="pwd" type="password" placeholder="비밀번호" value={form.pwd} onChange={handleChange} required />
      <input name="confirmPwd" type="password" placeholder="비밀번호 확인" value={form.confirmPwd} onChange={handleChange} required />
      <input name="name" placeholder="이름" value={form.name} onChange={handleChange} required />
      <input name="email" placeholder="이메일" value={form.email} onChange={handleChange} required />
      <input name="addr" placeholder="주소" value={form.addr} onChange={handleChange} />
      <input name="phone" placeholder="전화번호" value={form.phone} onChange={handleChange} required />
      <input name="ssn" placeholder="주민등록번호" value={form.ssn} onChange={handleChange} required />

      <button type="submit">가입하기</button>
    </form>
  );
};

export default SignupForm;