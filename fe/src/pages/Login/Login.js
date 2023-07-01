import {LockOutlined, UserOutlined} from '@ant-design/icons';
import {Button, Card, Form, Input, Typography} from 'antd';
import {useNavigate} from 'react-router-dom';
import {Trans, useTranslation} from "react-i18next";

const {Title,Text} = Typography;

const Login = () => {
    let navigate = useNavigate();
    const { t } = useTranslation();

  const onFinish = (values) => {
    console.log('Received values of form: ', values);
    let path = '/home';
    navigate(path)
    };
  return (
    <div 
      style={{
      display: "flex",
      justifyContent: "center",
      alignItems: "center",
      height: "100vh",
    }}>
    <Card style = {{width: 500}}>

    <Form
      name="normal_login"
      className="login-form"
      initialValues={{
        remember: true,
      }}
      onFinish={onFinish}
    >
        <Form.Item >
        <Title level = {2}>Smart Survey</Title>
            <Text type = "secondary">
                <Trans t={t}>login.description</Trans>
            </Text>
        </Form.Item>
        
      <Form.Item
        name="username"
        rules={[
          {
            required: true,
            message: <Trans t={t}>login.username_message</Trans>,
          },
        ]}
      >
        <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Username" />
      </Form.Item>
      <Form.Item
        name="password"
        rules={[
          {
            required: true,
            message: <Trans t={t}>login.password_message</Trans>
          },
        ]}
      >
        <Input.Password
          prefix={<LockOutlined className="site-form-item-icon" />}
          type="password"
          placeholder="Password"
        />
      </Form.Item>
      <Form.Item>
        <Button type="primary" htmlType="submit" className="login-form-button">
            <Trans t={t}>login.button</Trans>
        </Button>
      </Form.Item>
    </Form>
        </Card>
    </div>
  );
};

export {Login};
