import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [userId, setUserId] = useState('');
  const [pwd, setPwd] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    console.log('로그인 시도:', { userId, pwd });
    
    try {
    const res = await axios.post('http://localhost:8081/api/users/login', {
      userId,
      pwd,
    });

    alert(res.data.message); // "로그인 성공"

    if (res.data.role === 'ADMIN') {
      navigate('/admin');
    } else {
      navigate('/home');
    }
  } catch (err: any) {
    alert(err.response?.data?.message || '로그인 실패');
  }
  };

  return (
    <div style={{ maxWidth: 400, margin: '100px auto' }}>
      <h2>로그인</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>아이디</label>
          <input
            type="text"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            required
          />
        </div>
        <div style={{ marginTop: 12 }}>
          <label>비밀번호</label>
          <input
            type="password"
            value={pwd}
            onChange={(e) => setPwd(e.target.value)}
            required
          />
        </div>
        <button type="submit" onClick={handleSubmit} style={{ marginTop: 16 }}>
          로그인
        </button>
        <button type="button" onClick={() => navigate('/signup')} style={{ marginTop: 16 }}>
          회원가입
        </button>
      </form>
    </div>
  );
};

export default Login;