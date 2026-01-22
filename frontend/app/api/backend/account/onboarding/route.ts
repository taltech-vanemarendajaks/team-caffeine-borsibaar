import { NextRequest, NextResponse } from 'next/server';
import { backendUrl, JSON_HEADERS } from '@/utils/constants';

export async function POST(request: NextRequest) {
  try {
    const body = await request.json();
    
    const response = await fetch(`${backendUrl}/api/account/onboarding`, {
      method: 'POST',
      headers: {
        ...JSON_HEADERS,
        'Cookie': request.headers.get('cookie') || '',
      },
      credentials: 'include',
      body: JSON.stringify(body),
    });

    // Handle 204 No Content before reading response body
    if (response.status === 204) {
      return NextResponse.json({ success: true }, { status: 200 });
    }

    const text = await response.text();
    
    return new NextResponse(text, { 
      status: response.status,
      headers: {
        'Content-Type': response.headers.get('content-type') || JSON_HEADERS["Content-Type"],
        'Set-Cookie': response.headers.get('set-cookie') || '',
      }
    });
  } catch (error) {
    console.error('Proxy error:', error);
    return NextResponse.json(
      { error: 'Failed to complete onboarding' }, 
      { status: 500 }
    );
  }
}