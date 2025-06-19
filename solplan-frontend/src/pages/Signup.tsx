import SignupForm from '../components/SignupForm';
import { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

const Signup = () => {

  const navigate = useNavigate();

  useEffect(() => {
    const userId = localStorage.getItem('userId');
    const role = localStorage.getItem('role');
    
    if (userId) {
      alert('이미 로그인된 상태입니다.');
      if (role === 'ADMIN') {
        navigate('/admin');
      } else {
        navigate('/home');
      }
    }
  }, []);

  return (
    <div style={{ maxWidth: 500, margin: '50px auto' }}>
      <h2>회원가입</h2>
      <SignupForm />
      <button onClick={() => navigate('/')}>
        뒤로가기
      </button>
    </div>
  );
};

export default Signup;