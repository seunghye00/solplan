import { useState } from 'react';

const Login = () => {
  const [userId, setUserId] = useState('');
  const [pwd, setPwd] = useState('');

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    console.log('로그인 시도:', { userId, pwd });
    // TODO: API 연동
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
        <button type="submit" style={{ marginTop: 16 }}>
          로그인
        </button>
      </form>
    </div>
  );
};

export default Login;